package kz.junior.task.services;


import kz.junior.task.dto.MonthlyLimitDTO;

import java.util.List;

public interface MonthlyLimitService {
  MonthlyLimitDTO setNewLimit(MonthlyLimitDTO monthlyLimitDTO);

  MonthlyLimitDTO setNewBalance(MonthlyLimitDTO monthlyLimitDTO);

  MonthlyLimitDTO getMonthlyLimitByDateAndCategory(Long id);

  List<MonthlyLimitDTO> getAllLimits();
}
