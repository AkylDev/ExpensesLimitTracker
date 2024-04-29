package kz.junior.task.mapper;

import kz.junior.task.TestData;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.model.CategoryModel;
import kz.junior.task.model.MonthlyLimitModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootTest
public class MonthlyLimitTest {

  private final MonthlyLimitMapper mapper = new MonthlyLimitMapperImpl();

  @Test
  public void testModelToDto(){
    CategoryModel category = new CategoryModel();
    category.setName("goods");

    MonthlyLimitModel model = new MonthlyLimitModel();
    model.setId(77L);
    model.setCreatedDate(ZonedDateTime.now(ZoneId.of("Asia/Almaty")));
    model.setLimitAmount(1000);
    model.setCategory(category);

    MonthlyLimitDTO dto = mapper.toDto(model);

    Assertions.assertEquals(model.getId(), dto.getId());
    Assertions.assertEquals(model.getCreatedDate(), dto.getCreatedDate());
    Assertions.assertEquals(model.getLimitAmount(), dto.getLimitAmount());
  }

  @Test
  public void testDtoToModel(){
    MonthlyLimitDTO dto = TestData.testMonthlyLimitDtoData();

    MonthlyLimitModel model = mapper.fromDto(dto);

    Assertions.assertEquals(dto.getId(), model.getId());
    Assertions.assertEquals(dto.getCreatedDate(), model.getCreatedDate());
    Assertions.assertEquals(dto.getLimitAmount(), model.getLimitAmount());
  }
}
