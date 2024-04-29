package kz.junior.task.mapper;

import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.model.MonthlyLimitModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonthlyLimitMapper {

  @Mapping(source = "category", target = "category")
  MonthlyLimitDTO toDto(MonthlyLimitModel monthlyLimit);

  @Mapping(source = "category", target = "category")
  MonthlyLimitModel fromDto(MonthlyLimitDTO monthlyLimitDto);

  List<MonthlyLimitDTO> toMonthlyLimitDtoList(List<MonthlyLimitModel> monthlyLimitList);
  List<MonthlyLimitModel> toMonthlyLimitModelList(List<MonthlyLimitDTO> monthlyLimitDtoList);
}
