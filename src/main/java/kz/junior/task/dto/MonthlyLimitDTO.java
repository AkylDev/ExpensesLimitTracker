package kz.junior.task.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
public class MonthlyLimitDTO {
  private Long id;
  private ZonedDateTime createdDate;
  private int limitAmount;
  private int limitBalance;
  private CategoryDTO category;

}
