package kz.junior.task.mapper;

import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.model.MonthlyLimitModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonthlyLimitMapper {
  MonthlyLimitDTO toDto(MonthlyLimitModel monthlyLimit);

  MonthlyLimitModel fromDto(MonthlyLimitDTO monthlyLimitDto);

  List<MonthlyLimitDTO> toMonthlyLimitDtoList(List<MonthlyLimitModel> monthlyLimitList);
  List<MonthlyLimitModel> toMonthlyLimitModelList(List<MonthlyLimitDTO> monthlyLimitDtoList);
}
