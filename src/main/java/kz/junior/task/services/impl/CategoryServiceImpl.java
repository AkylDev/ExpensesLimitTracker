package kz.junior.task.services.impl;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.mapper.CategoryMapper;
import kz.junior.task.repositories.CategoryRepository;
import kz.junior.task.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;


  @Override
  public CategoryDTO save(CategoryDTO categoryDTO){
    return categoryMapper.toDto(categoryRepository.save(categoryMapper.fromDto(categoryDTO)));
  }

  @Override
  public List<CategoryDTO> getCategories() {
    return categoryMapper.toCategoryDtoList(categoryRepository.findAll());
  }

  @Override
  public void deleteCategoryById(Long id) {
    categoryRepository.deleteById(id);
  }

}
