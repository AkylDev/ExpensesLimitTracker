package kz.junior.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.services.MonthlyLimitService;
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
public class MonthlyLimitControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testThatLimitIsCreated() throws Exception{
    final MonthlyLimitDTO monthlyLimitDTO = new MonthlyLimitDTO();
    MonthlyLimitDTO.builder()
            .limitAmount(1100)
            .category(new CategoryDTO(1L, "something"))
            .build();

    final ObjectMapper objectMapper = new ObjectMapper();
    final String limitJson = objectMapper.writeValueAsString(monthlyLimitDTO);

    mockMvc.perform(MockMvcRequestBuilders.post("/limits")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(limitJson))
            .andExpect(MockMvcResultMatchers.status().isCreated());
  }


}
