package kz.junior.task.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.junior.task.dto.ExchangeRateDTO;

public interface ExchangeRateService {
  String getExchangeRateJson();

  ExchangeRateDTO findLastDataFromTable();

  void getCurrentExchangeRate() throws JsonProcessingException;
}
