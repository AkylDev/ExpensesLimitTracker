package kz.junior.task.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;

@Getter
@Setter
public class MonthlyLimitDTO {
  private Long id;
  private YearMonth createdDate;
  private int limitAmount;
  private int limitBalance;

  @ManyToOne
  private CategoryDTO category;

}
