package kz.junior.task.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "exchange_rates")
public class ExchangeRateModel {
  @Id
  private String id;

  private double kzt;

  private double rub;

  private String timeLastUpdate;
}