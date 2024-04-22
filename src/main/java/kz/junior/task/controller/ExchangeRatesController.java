package kz.junior.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.junior.task.services.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rates")
public class ExchangeRatesController {
  private final ExchangeRateService exchangeRateService;

  @GetMapping
  public String getExchangeRateApi() throws JsonProcessingException {
    exchangeRateService.getCurrentExchangeRate();
    return exchangeRateService.getExchangeRateJson();
  }
}
