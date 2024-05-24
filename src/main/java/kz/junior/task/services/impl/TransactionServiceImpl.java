package kz.junior.task.services.impl;

import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.mapper.TransactionMapper;
import kz.junior.task.repositories.TransactionRepository;
import kz.junior.task.services.ExchangeRateService;
import kz.junior.task.services.MonthlyLimitService;
import kz.junior.task.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final TransactionMapper transactionMapper;


  private final ExchangeRateService exchangeRateService;

  private final MonthlyLimitService monthlyLimitService;


  @Override
  public TransactionDTO setTransaction(TransactionDTO transactionDTO) {
    MonthlyLimitDTO limitToday = monthlyLimitService.
            getMonthlyLimitByDateAndCategory(transactionDTO.getCategory().getId());

    transactionDTO.setTransactionDate(LocalDate.now());
    ExchangeRateDTO lastExchangeRateData = exchangeRateService.findLastDataFromTable();
    transactionDTO.setKzt(lastExchangeRateData.getKzt() * transactionDTO.getExpense());
    transactionDTO.setRub(lastExchangeRateData.getRub() * transactionDTO.getExpense());

    int leftover = limitToday.getLimitBalance() - transactionDTO.getExpense();
    if (leftover < 0){
      transactionDTO.setLimitExceeded(true);
    }

    limitToday.setLimitBalance(leftover);
    monthlyLimitService.setNewBalance(limitToday);

    return transactionMapper.toDto(transactionRepository.save(transactionMapper.fromDto(transactionDTO)));
  }

  @Override
  public List<TransactionDTO> getExceededTransactions() {
    return transactionMapper.toTransactionDtoList(transactionRepository.getAllByLimitExceededTrue());
  }

}
