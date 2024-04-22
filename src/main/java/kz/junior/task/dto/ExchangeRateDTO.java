package kz.junior.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateDTO {
  private Long id;
  private double kztValue;
  private double rubValue;
  private String timeLastUpdate;
}
