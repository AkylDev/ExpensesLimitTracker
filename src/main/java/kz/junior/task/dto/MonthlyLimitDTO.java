package kz.junior.task.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class MonthlyLimitDTO {
  private Long id;
  private ZonedDateTime createdDate;
  private int limitAmount;
  private int limitBalance;

  @ManyToOne
  private CategoryDTO category;

}
