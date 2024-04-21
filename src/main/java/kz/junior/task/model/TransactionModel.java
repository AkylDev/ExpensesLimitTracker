package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "t_transactions")
public class TransactionModel extends BaseModel{

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Column(name = "expense_USD")
  private int expense;

  @Column(name = "KZT")
  private double kzt;

  @Column(name = "RUB")
  private double rub;

  @OneToOne
  private CategoryModel categoryModel;
}
