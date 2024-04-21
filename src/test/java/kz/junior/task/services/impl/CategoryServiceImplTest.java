package kz.junior.task.services.impl;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.mapper.CategoryMapper;
import kz.junior.task.model.CategoryModel;
import kz.junior.task.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

  @Mock
  private CategoryRepository categoryRepository;

  @Mock
  private CategoryMapper categoryMapper;

  @InjectMocks
  private CategoryServiceImpl categoryService;

  @Test
  public void testThatCategoryIsSaved(){
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(77L);
    categoryDTO.setName("cakes");

    CategoryModel categoryModel = new CategoryModel();
    categoryModel.setId(77L);
    categoryModel.setName("cakes");

    when(categoryMapper.fromDto(categoryDTO)).thenReturn(categoryModel);
    when(categoryMapper.toDto(categoryModel)).thenReturn(categoryDTO);

    when(categoryRepository.save(categoryModel)).thenReturn(categoryModel);

    CategoryDTO result = categoryService.save(categoryDTO);

    verify(categoryMapper).fromDto(categoryDTO);
    verify(categoryRepository).save(categoryModel);
    verify(categoryMapper).toDto(categoryModel);

    Assertions.assertEquals(categoryDTO, result);
  }

  @Test
  public void testGetCategoriesReturnsEmptyWhenNoCategories() {
    when(categoryRepository.findAll()).thenReturn(Collections.emptyList());

    final List<CategoryDTO> result = categoryService.getCategories();

    Assertions.assertEquals(0, result.size());
  }



  @Test
  public void testGetCategoriesReturnCategoriesWhenExists(){
    final CategoryModel categoryModel = new CategoryModel();
    categoryModel.setId(77L);
    categoryModel.setName("cakes");
    when(categoryRepository.findAll()).thenReturn(Collections.singletonList(categoryModel));

    final CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(77L);
    categoryDTO.setName("cakes");
    when(categoryMapper.toCategoryDtoList(Collections.singletonList(categoryModel)))
            .thenReturn(Collections.singletonList(categoryDTO));

    final List<CategoryDTO> result = categoryService.getCategories();
    Assertions.assertEquals(1, result.size());
  }

  @Test
  public void testDeleteCategory(){
    final Long id = 3L;
    categoryService.deleteCategoryById(id);
    verify(categoryRepository, times(1)).deleteById(eq(id));
  }

}
