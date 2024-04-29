package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "t_monthly_limit")
public class MonthlyLimitModel extends BaseModel{

  @Column(name = "created_date")
  private ZonedDateTime createdDate;

  @Column(name = "limit_amount")
  private int limitAmount;

  @Column(name = "limit_balance")
  private int limitBalance;

  @ManyToOne
  private CategoryModel category;

}
