package kz.junior.task.mapper;

import kz.junior.task.TestData;
import kz.junior.task.dto.ExchangeRateDTO;
import kz.junior.task.model.ExchangeRateModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExchangeRateMapperTest {

  private final ExchangeRateMapper mapper = new ExchangeRateMapperImpl();

  @Test
  public void testModelToDto(){
    ExchangeRateModel model = new ExchangeRateModel();
    model.setId("6650a978986aa67e330e0f25");
    model.setKzt(445);
    model.setRub(93);
    model.setTimeLastUpdate("01.01.2022");

    ExchangeRateDTO dto = mapper.toDto(model);

    Assertions.assertEquals(model.getId(), dto.getId());
    Assertions.assertEquals(model.getKzt(), dto.getKzt());
    Assertions.assertEquals(model.getRub(), dto.getRub());
    Assertions.assertEquals(model.getTimeLastUpdate(), dto.getTimeLastUpdate());
  }

  @Test
  public void testDtoToModel(){
    ExchangeRateDTO dto = TestData.testExchangeRateDtoData();

    ExchangeRateModel model = mapper.fromDto(dto);

    Assertions.assertEquals(dto.getId(), model.getId());
    Assertions.assertEquals(dto.getKzt(), model.getKzt());
    Assertions.assertEquals(dto.getRub(), model.getRub());
    Assertions.assertEquals(dto.getTimeLastUpdate(), model.getTimeLastUpdate());
  }
}
