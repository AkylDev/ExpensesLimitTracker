package kz.junior.task.services.impl;

import kz.junior.task.TestData;
import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.dto.MonthlyLimitDTO;
import kz.junior.task.mapper.MonthlyLimitMapper;
import kz.junior.task.model.CategoryModel;
import kz.junior.task.model.MonthlyLimitModel;
import kz.junior.task.repositories.MonthlyLimitRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MonthlyLimitImplTest {

  @Mock
  private MonthlyLimitMapper monthlyLimitMapper;

  @Mock
  private MonthlyLimitRepository monthlyLimitRepository;

  @InjectMocks
  private MonthlyLimitServiceImpl monthlyLimitService;


  @Test
  public void testThatLimitIsCreated(){
    MonthlyLimitDTO monthlyLimitDTO = TestData.testMonthlyLimitDtoData();

    MonthlyLimitModel monthlyLimitModel = monthlyLimitMapper.fromDto(monthlyLimitDTO);

    when(monthlyLimitMapper.fromDto(monthlyLimitDTO)).thenReturn(monthlyLimitModel);
    when(monthlyLimitMapper.toDto(monthlyLimitModel)).thenReturn(monthlyLimitDTO);

    when(monthlyLimitRepository.save(monthlyLimitModel)).thenReturn(monthlyLimitModel);

    MonthlyLimitDTO result = monthlyLimitService.setNewLimit(monthlyLimitDTO);

    verify(monthlyLimitMapper, times(2)).fromDto(monthlyLimitDTO);
    verify(monthlyLimitRepository).save(monthlyLimitModel);
    verify(monthlyLimitMapper).toDto(monthlyLimitModel);

    Assertions.assertEquals(monthlyLimitDTO, result);
  }

  @Test
  public void setGetAllLimitsReturnMonthlyLimitWhenExists() {
    final CategoryModel categoryModel = new CategoryModel();
    categoryModel.setId(1L);
    categoryModel.setName("service");

    final CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(1L);
    categoryDTO.setName("service");

    final MonthlyLimitModel monthlyLimitModel = monthlyLimitMapper.fromDto(TestData.testMonthlyLimitDtoData());
    when(monthlyLimitRepository.findAll()).thenReturn(Collections.singletonList(monthlyLimitModel));

    final MonthlyLimitDTO monthlyLimitDTO = TestData.testMonthlyLimitDtoData();
    when(monthlyLimitMapper.toMonthlyLimitDtoList(Collections.singletonList(monthlyLimitModel)))
            .thenReturn(Collections.singletonList(monthlyLimitDTO));

    final List<MonthlyLimitDTO> result = monthlyLimitService.getAllLimits();
    Assertions.assertEquals(1, result.size());
  }
}
