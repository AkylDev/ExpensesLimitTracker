package kz.junior.task.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ExchangeRateService {
  String getExchangeRateJson();

  void getCurrentExchangeRate() throws JsonProcessingException;
}
