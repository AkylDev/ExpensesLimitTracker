package kz.junior.task.mapper;

import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.model.TransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

  @Mapping(source = "category", target = "category")
  TransactionDTO toDto(TransactionModel transaction);

  @Mapping(source = "category", target = "category")
  TransactionModel fromDto(TransactionDTO transactionDto);

  List<TransactionDTO> toTransactionDtoList(List<TransactionModel> transactionList);

  List<TransactionModel> toTransactionModelList(List<TransactionDTO> transactionDtoList);
}
