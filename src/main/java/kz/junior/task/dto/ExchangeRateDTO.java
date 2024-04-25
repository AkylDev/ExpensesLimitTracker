package kz.junior.task.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDTO {
  private Long id;
  private double kztValue;
  private double rubValue;
  private String timeLastUpdate;
}
