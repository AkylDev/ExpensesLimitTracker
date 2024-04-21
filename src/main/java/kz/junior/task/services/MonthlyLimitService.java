package kz.junior.task.services;


import kz.junior.task.dto.MonthlyLimitDTO;

import java.util.List;

public interface MonthlyLimitService {
  MonthlyLimitDTO setLimit(MonthlyLimitDTO monthlyLimitDTO);

  List<MonthlyLimitDTO> getAllLimits();
}
