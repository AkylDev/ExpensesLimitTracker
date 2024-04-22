package kz.junior.task.dto;

import jakarta.persistence.ManyToOne;
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
  private boolean limitExceeded;

  @ManyToOne
  private CategoryDTO category;
}
