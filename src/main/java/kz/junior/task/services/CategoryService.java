package kz.junior.task.services;


import kz.junior.task.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

  CategoryDTO save(CategoryDTO categoryDTO);

  List<CategoryDTO> getCategories();

  void deleteCategoryById(Long id);
}
