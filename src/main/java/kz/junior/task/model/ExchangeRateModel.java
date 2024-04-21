package kz.junior.task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_exchange_rates")
public class ExchangeRateModel extends BaseModel {
  @Column(name = "KZT")
  private double kztValue;

  @Column(name = "RUB")
  private double rubValue;

  @Column(name = "updated_date")
  private String timeLastUpdate;
}