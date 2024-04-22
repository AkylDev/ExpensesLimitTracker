package kz.junior.task.services;

import kz.junior.task.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
  TransactionDTO setTransaction(TransactionDTO transactionDTO);

  List<TransactionDTO> getTranasactionsList();
}
