package kz.junior.task.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.junior.task.api.ExchangeRatesApi;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.mapper.ExchangeRateMapper;
import kz.junior.task.repositories.ExchangeRateRepository;
import kz.junior.task.services.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;
  private final ExchangeRateMapper exchangeMapper;

  @Override
  public String getExchangeRateJson() {
    RestTemplate restTemplate = new RestTemplate();

    String apiUrl = "https://v6.exchangerate-api.com/v6/c9d48243dcc1bbe061817d0f/latest/USD";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

    return response.getBody();
  }

  @Override
  public ExchangeRateDTO findLastDataFromTable() {
    return exchangeMapper.toDto(exchangeRateRepository.findFirstByOrderByIdDesc());
  }

  @Override
//  @Scheduled(cron = "0 * * * * *")
  public void getCurrentExchangeRate() throws JsonProcessingException {
    ExchangeRateDTO exchangeRateDto = new ExchangeRateDTO();
    String jsonResponse = getExchangeRateJson();
    ObjectMapper objectMapper = new ObjectMapper();
    ExchangeRatesApi exchangeRatesApi = objectMapper.readValue(jsonResponse, ExchangeRatesApi.class);
    exchangeRateDto.setKztValue(exchangeRatesApi.getConversion_rates().get("KZT"));
    exchangeRateDto.setRubValue(exchangeRatesApi.getConversion_rates().get("RUB"));
    exchangeRateDto.setTimeLastUpdate(exchangeRatesApi.getTime_last_update_utc());
    exchangeRateRepository.save(exchangeMapper.fromDto(exchangeRateDto));
  }
}
