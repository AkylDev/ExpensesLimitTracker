package kz.junior.task.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import kz.junior.task.model.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;

@Getter
@Setter
public class MonthlyLimitDTO {
  private Long id;
  private YearMonth createdDate;
  private int limitAmount;

  @ManyToOne
  private CategoryDTO category;

}
