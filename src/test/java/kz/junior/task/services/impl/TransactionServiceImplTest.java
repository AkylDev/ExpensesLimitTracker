package kz.junior.task.services.impl;

import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.mapper.TransactionMapper;
import kz.junior.task.model.TransactionModel;
import kz.junior.task.repositories.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

  @Mock
  private MonthlyLimitServiceImpl monthlyLimitService;

  @Mock
  private ExchangeRateServiceImpl exchangeRateService;

  @Mock
  private TransactionRepository transactionRepository;

  @Mock
  private TransactionMapper transactionMapper;

  @InjectMocks
  private TransactionServiceImpl transactionService;

  @Test
  public void testSetTransaction() {
    CategoryDTO categoryDTO = TestData.testCategoryDtoData();
    MonthlyLimitDTO mockLimitToday = TestData.testMonthlyLimitDtoData();
    ExchangeRateDTO mockExchangeRateData = TestData.testExchangeRateDtoData();

    TransactionDTO transactionDTO = new TransactionDTO();
    transactionDTO.setId(44L);
    transactionDTO.setCategory(categoryDTO);
    transactionDTO.setExpense(500);

    TransactionModel savedTransactionModel = new TransactionModel();
    when(transactionMapper.fromDto(transactionDTO)).thenReturn(savedTransactionModel);
    when(transactionMapper.toDto(savedTransactionModel)).thenReturn(transactionDTO);

    when(monthlyLimitService.getMonthlyLimitByDateAndCategory(anyLong())).thenReturn(mockLimitToday);
    when(exchangeRateService.findLastDataFromTable()).thenReturn(mockExchangeRateData);
    when(transactionRepository.save(savedTransactionModel)).thenReturn(savedTransactionModel);

    TransactionDTO result = transactionService.setTransaction(transactionDTO);

    verify(transactionMapper).fromDto(transactionDTO);
    verify(monthlyLimitService).getMonthlyLimitByDateAndCategory(anyLong());
    verify(exchangeRateService).findLastDataFromTable();
    verify(transactionRepository).save(savedTransactionModel);

    Assertions.assertNotNull(result);
  }
}
