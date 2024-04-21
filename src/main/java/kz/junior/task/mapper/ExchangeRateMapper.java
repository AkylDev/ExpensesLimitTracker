package kz.junior.task.mapper;

import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.model.ExchangeRateModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
  ExchangeRateDTO toDto(ExchangeRateModel exchangeRate);

  ExchangeRateModel fromDto(ExchangeRateDTO exchangeRateDto);

  List<ExchangeRateDTO> toExchangeRateDtoList(List<ExchangeRateModel> exchangeRateList);
  List<ExchangeRateModel> toExchangeRateModelList(List<ExchangeRateDTO> exchangeRateDtoList);
}
