package kz.junior.task.dto;

import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
