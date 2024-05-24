package kz.junior.task.dto;

import lombok.*;

@Getter
@Setter
public class ExchangeRateDTO {
  private String id;
  private double kzt;
  private double rub;
  private String timeLastUpdate;
}
