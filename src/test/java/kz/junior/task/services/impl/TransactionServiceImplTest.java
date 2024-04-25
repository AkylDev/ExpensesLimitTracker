package kz.junior.task.services.impl;

import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.mapper.TransactionMapper;
import kz.junior.task.model.TransactionModel;
import kz.junior.task.repositories.TransactionRepository;
import kz.junior.task.services.ExchangeRateService;
import kz.junior.task.services.MonthlyLimitService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

  @Mock
  private MonthlyLimitService monthlyLimitService;

  @Mock
  private ExchangeRateService exchangeRateService;

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

  @Test
  public void testGetExceededTransactions() {
    TransactionModel transaction1 = new TransactionModel();
    transaction1.setId(1L);
    transaction1.setLimitExceeded(true);

    TransactionModel transaction2 = new TransactionModel();
    transaction2.setId(2L);
    transaction2.setLimitExceeded(true);

    List<TransactionModel> exceededTransactions = new ArrayList<>();
    exceededTransactions.add(transaction1);
    exceededTransactions.add(transaction2);

    when(transactionRepository.getAllByLimitExceededTrue()).thenReturn(exceededTransactions);

    TransactionDTO transactionDTO1 = new TransactionDTO();
    transactionDTO1.setId(1L);

    TransactionDTO transactionDTO2 = new TransactionDTO();
    transactionDTO2.setId(2L);

    when(transactionMapper.toTransactionDtoList(exceededTransactions)).thenReturn(List.of(transactionDTO1, transactionDTO2));

    List<TransactionDTO> result = transactionService.getExceededTransactions();

    verify(transactionRepository).getAllByLimitExceededTrue();
    verify(transactionMapper).toTransactionDtoList(exceededTransactions);

    Assertions.assertNotNull(result);
    Assertions.assertEquals(2, result.size());
    Assertions.assertEquals(1L, result.get(0).getId());
    Assertions.assertEquals(2L, result.get(1).getId());
  }
}
