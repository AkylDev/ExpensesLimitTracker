package kz.junior.task;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.dto.TransactionDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestData {
  private TestData(){

  }

  public static CategoryDTO testCategoryDtoData(){
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(11L);
    categoryDTO.setName("service");
    return categoryDTO;
  }

  public static ExchangeRateDTO testExchangeRateDtoData(){
    ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
    exchangeRateDTO.setId("6650a978986aa67e330e0f25");
    exchangeRateDTO.setKzt(465);
    exchangeRateDTO.setRub(93);
    exchangeRateDTO.setTimeLastUpdate("Wed, 24 Apr 2024 00:00:01 +0000");
    return exchangeRateDTO;
  }

  public static MonthlyLimitDTO testMonthlyLimitDtoData(){
    MonthlyLimitDTO monthlyLimitDTO = new MonthlyLimitDTO();
    monthlyLimitDTO.setId(33L);
    monthlyLimitDTO.setLimitAmount(1000);
    monthlyLimitDTO.setLimitBalance(1000);
    monthlyLimitDTO.setCreatedDate(ZonedDateTime.now(ZoneId.of("Asia/Almaty")));
    monthlyLimitDTO.setCategory(TestData.testCategoryDtoData());
    return monthlyLimitDTO;
  }

  public static TransactionDTO testTransactionDtoData(){
    TransactionDTO transactionDTO = new TransactionDTO();
    transactionDTO.setId(44L);
    transactionDTO.setExpense(500);
    transactionDTO.setKzt(500 * TestData.testExchangeRateDtoData().getKzt());
    transactionDTO.setRub(500 * TestData.testExchangeRateDtoData().getRub());
    transactionDTO.setTransactionDate(LocalDate.now());
    transactionDTO.setLimitExceeded(false);
    transactionDTO.setCategory(TestData.testCategoryDtoData());
    return transactionDTO;
  }


}
