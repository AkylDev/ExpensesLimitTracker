package kz.junior.task.services.impl;

import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.mapper.MonthlyLimitMapper;
import kz.junior.task.repositories.MonthlyLimitRepository;
import kz.junior.task.services.MonthlyLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyLimitServiceImpl implements MonthlyLimitService {

  private final MonthlyLimitRepository monthlyLimitRepository;
  private final MonthlyLimitMapper monthlyLimitMapper;

  @Override
  public MonthlyLimitDTO setNewLimit(MonthlyLimitDTO monthlyLimitDTO) {
    monthlyLimitDTO.setCreatedDate(ZonedDateTime.now(ZoneId.of("Asia/Almaty")));
    monthlyLimitDTO.setLimitBalance(monthlyLimitDTO.getLimitAmount());
    return monthlyLimitMapper.toDto(monthlyLimitRepository.save(monthlyLimitMapper.fromDto(monthlyLimitDTO)));
  }

  @Override
  public MonthlyLimitDTO setNewBalance(MonthlyLimitDTO monthlyLimitDTO) {
    return monthlyLimitMapper.toDto(monthlyLimitRepository.save(monthlyLimitMapper.fromDto(monthlyLimitDTO)));
  }

  @Override
  public MonthlyLimitDTO getMonthlyLimitByDateAndCategory(Long id) {
//    System.out.println(monthlyLimitRepository.findFirstByCategory_IdOrderByCreatedDateDesc(date, id).getId() + "HELLO");
    return monthlyLimitMapper.toDto(monthlyLimitRepository.findFirstByCategory_IdOrderByCreatedDateDesc(id));
  }

  @Override
  public List<MonthlyLimitDTO> getAllLimits() {
    return monthlyLimitMapper.toMonthlyLimitDtoList(monthlyLimitRepository.findAll());
  }
}
