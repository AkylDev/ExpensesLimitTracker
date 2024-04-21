package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.*;
import org.mapstruct.Mapper;

import java.time.YearMonth;

@Getter
@Setter
@Entity
@Table(name = "t_monthly_limit")
public class MonthlyLimitModel extends BaseModel{

  @Column(name = "created_date")
  private YearMonth createdDate;

  @Column(name = "limit_amount")
  private int limitAmount;

  @ManyToOne
  private CategoryModel category;

}
