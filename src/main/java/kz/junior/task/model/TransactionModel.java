package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "t_transactions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel extends BaseModel{

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Column(name = "expense_USD")
  private int expense;

  @Column(name = "expense_KZT")
  private double kzt;

  @Column(name = "expense_RUB")
  private double rub;

  @Column(name = "limit_exceeded")
  private boolean limitExceeded;

  @ManyToOne
  private CategoryModel category;
}
