package kz.junior.task.mapper;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.TransactionDTO;
import kz.junior.task.model.CategoryModel;
import kz.junior.task.model.TransactionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionMapperTest {
    private final TransactionMapper mapper = new TransactionMapperImpl();

    @Test
    public void testModelToDto() {
      CategoryModel categoryModel = new CategoryModel();
      categoryModel.setName("goods");

      TransactionModel model = new TransactionModel();
      model.setId(77L);
      model.setExpense(500);
      model.setKzt(222500);
      model.setRub(46500);
      model.setCategory(categoryModel);

      TransactionDTO dto = mapper.toDto(model);

      Assertions.assertEquals(model.getId(), dto.getId());
      Assertions.assertEquals(model.getExpense(), dto.getExpense());
      Assertions.assertEquals(model.getKzt(), dto.getKzt());
      Assertions.assertEquals(model.getRub(), dto.getRub());
    }

  @Test
  public void testDtoToModel() {
    CategoryDTO category = new CategoryDTO();
    category.setName("goods");

    TransactionDTO dto = new TransactionDTO();
    dto.setId(77L);
    dto.setExpense(500);
    dto.setKzt(222500);
    dto.setRub(46500);
    dto.setCategory(category);

    TransactionModel model = mapper.fromDto(dto);

    Assertions.assertEquals(dto.getId(), model.getId());
    Assertions.assertEquals(dto.getExpense(), model.getExpense());
    Assertions.assertEquals(dto.getKzt(), model.getKzt());
    Assertions.assertEquals(dto.getRub(), model.getRub());
  }

  }