package kz.junior.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CategoryControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testThatCategoryIsReturnsCategories() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/categories"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().
                    string("[{\"id\":1,\"name\":\"goods\"},{\"id\":2,\"name\":\"services\"}]"));
  }


  @Test
  public void testThatCategoryIsCreated() throws Exception{
    final CategoryDTO categoryDTO = TestData.testCategoryDtoData();
    final ObjectMapper objectMapper = new ObjectMapper();
    final String categoryJson = objectMapper.writeValueAsString(categoryDTO);

    mockMvc.perform(MockMvcRequestBuilders.post("/categories")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(categoryJson))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(categoryDTO.getName()));
  }

}
