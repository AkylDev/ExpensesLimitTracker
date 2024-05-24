package kz.junior.task.scheduled;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.junior.task.services.ExchangeRateService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateScheduler {
  private final ExchangeRateService exchangeRateService;

  public ExchangeRateScheduler(ExchangeRateService exchangeRateService) {
    this.exchangeRateService = exchangeRateService;
  }

  @Scheduled(cron = "0 * * * * *")
  public void updateExchangeRate() {
    try {
      exchangeRateService.getCurrentExchangeRate();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
