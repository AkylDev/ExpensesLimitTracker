package kz.junior.task.mapper;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.model.CategoryModel;
import kz.junior.task.model.MonthlyLimitModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.YearMonth;

@SpringBootTest
public class MonthlyLimitTest {

  private final MonthlyLimitMapper mapper = new MonthlyLimitMapperImpl();

  @Test
  public void testModelToDto(){
    CategoryModel category = new CategoryModel();
    category.setName("goods");

    MonthlyLimitModel model = new MonthlyLimitModel();
    model.setId(77L);
    model.setCreatedDate(YearMonth.now());
    model.setLimitAmount(1000);
    model.setCategory(category);

    MonthlyLimitDTO dto = mapper.toDto(model);

    Assertions.assertEquals(model.getId(), dto.getId());
    Assertions.assertEquals(model.getCreatedDate(), dto.getCreatedDate());
    Assertions.assertEquals(model.getLimitAmount(), dto.getLimitAmount());
  }

  @Test
  public void testDtoToModel(){
    CategoryDTO category = new CategoryDTO();
    category.setName("goods");

    MonthlyLimitDTO dto = new MonthlyLimitDTO();
    dto.setId(77L);
    dto.setCreatedDate(YearMonth.now());
    dto.setLimitAmount(1000);
    dto.setCategory(category);

    MonthlyLimitModel model = mapper.fromDto(dto);

    Assertions.assertEquals(dto.getId(), model.getId());
    Assertions.assertEquals(dto.getCreatedDate(), model.getCreatedDate());
    Assertions.assertEquals(dto.getLimitAmount(), model.getLimitAmount());
  }
}
