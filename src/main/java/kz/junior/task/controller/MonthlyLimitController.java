package kz.junior.task.controller;

import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.services.MonthlyLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/limits")
public class MonthlyLimitController {
  private final MonthlyLimitService monthlyLimitService;

  @PostMapping
  public ResponseEntity<MonthlyLimitDTO> setMonthlyLimit(@RequestBody MonthlyLimitDTO monthlyLimitDTO){
    final MonthlyLimitDTO savedLimit = monthlyLimitService.setLimit(monthlyLimitDTO);
    return new ResponseEntity<MonthlyLimitDTO>(savedLimit, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<MonthlyLimitDTO>> getAllMonthlyLimitsExisted(){
    return new ResponseEntity<>(monthlyLimitService.getAllLimits(), HttpStatus.OK);
  }
}
