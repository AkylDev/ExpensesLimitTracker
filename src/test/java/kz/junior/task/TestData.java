package kz.junior.task;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.model.CategoryModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestData {
  private TestData(){

  }

  public static CategoryDTO testCategoryDtoData(){
    return CategoryDTO.builder()
            .id(11L)
            .name("service")
            .build();
  }

  public static ExchangeRateDTO testExchangeRateDtoData(){
    return ExchangeRateDTO.builder()
            .id(22L)
            .kztValue(465)
            .rubValue(93)
            .timeLastUpdate("Wed, 24 Apr 2024 00:00:01 +0000")
            .build();
  }

  public static MonthlyLimitDTO testMonthlyLimitDtoData(){
    return MonthlyLimitDTO.builder()
            .id(33L)
            .limitAmount(1000)
            .limitBalance(1000)
            .createdDate(ZonedDateTime.now(ZoneId.of("Asia/Almaty")))
            .category(TestData.testCategoryDtoData())
            .build();
  }

  public static TransactionDTO testTransactionDtoData(){
    return TransactionDTO.builder()
            .id(44L)
            .expense(500)
            .kzt(500 * TestData.testExchangeRateDtoData().getKztValue())
            .rub(500 * TestData.testExchangeRateDtoData().getRubValue())
            .transactionDate(LocalDate.now())
            .limitExceeded(false)
            .category(TestData.testCategoryDtoData())
            .build();
  }


}
