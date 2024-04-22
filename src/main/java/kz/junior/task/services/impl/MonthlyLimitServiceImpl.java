package kz.junior.task.services.impl;

import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.mapper.MonthlyLimitMapper;
import kz.junior.task.repositories.MonthlyLimitRepository;
import kz.junior.task.services.MonthlyLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyLimitServiceImpl implements MonthlyLimitService {

  private final MonthlyLimitRepository monthlyLimitRepository;
  private final MonthlyLimitMapper monthlyLimitMapper;

  @Override
  public MonthlyLimitDTO setNewLimit(MonthlyLimitDTO monthlyLimitDTO) {
    monthlyLimitDTO.setCreatedDate(YearMonth.now());
    monthlyLimitDTO.setLimitBalance(monthlyLimitDTO.getLimitAmount());
    return monthlyLimitMapper.toDto(monthlyLimitRepository.save(monthlyLimitMapper.fromDto(monthlyLimitDTO)));
  }

  @Override
  public MonthlyLimitDTO setNewBalance(MonthlyLimitDTO monthlyLimitDTO) {
    return monthlyLimitMapper.toDto(monthlyLimitRepository.save(monthlyLimitMapper.fromDto(monthlyLimitDTO)));
  }

  @Override
  public MonthlyLimitDTO getMonthlyLimitByDateAndCategory(YearMonth date, Long id) {
    return monthlyLimitMapper.toDto(monthlyLimitRepository.findByCreatedDateAndCategory_Id(date, id));
  }

  @Override
  public List<MonthlyLimitDTO> getAllLimits() {
    return monthlyLimitMapper.toMonthlyLimitDtoList(monthlyLimitRepository.findAll());
  }
}
