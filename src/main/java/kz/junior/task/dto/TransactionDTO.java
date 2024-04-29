package kz.junior.task.dto;

import lombok.*;

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
  private CategoryDTO category;
}
