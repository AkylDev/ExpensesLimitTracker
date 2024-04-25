package kz.junior.task.mapper;

import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.model.TransactionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
  TransactionDTO toDto(TransactionModel transaction);

  TransactionModel fromDto(TransactionDTO transactionDto);

  List<TransactionDTO> toTransactionDtoList(List<TransactionModel> transactionList);

  List<TransactionModel> toTransactionModelList(List<TransactionDTO> transactionDtoList);
}
