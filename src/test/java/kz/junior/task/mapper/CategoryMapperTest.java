package kz.junior.task.mapper;

import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.model.CategoryModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryMapperTest {

  private final CategoryMapper mapper = new CategoryMapperImpl();

  @Test
  public void testModelToDto(){
    CategoryModel model = new CategoryModel();
    model.setId(66L);
    model.setName("goods");

    CategoryDTO dto = mapper.toDto(model);

    Assertions.assertEquals(model.getId(), dto.getId());
    Assertions.assertEquals(model.getName(), dto.getName());
  }

  @Test
  public void testDtoToModel(){
    CategoryDTO dto = TestData.testCategoryDtoData();

    CategoryModel model = mapper.fromDto(dto);

    Assertions.assertEquals(dto.getId(), model.getId());
    Assertions.assertEquals(dto.getName(), model.getName());
  }
}
