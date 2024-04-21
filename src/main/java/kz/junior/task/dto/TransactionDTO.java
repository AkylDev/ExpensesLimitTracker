package kz.junior.task.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import kz.junior.task.model.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTO {
  private Long id;
  private LocalDate transactionDate;
  private int expense;
  private double kzt;
  private double rub;

  @OneToOne
  private CategoryDTO category;//map
}
