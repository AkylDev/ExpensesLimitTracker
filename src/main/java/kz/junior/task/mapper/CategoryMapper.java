package kz.junior.task.mapper;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.model.CategoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryDTO toDto(CategoryModel categoryModel);

  CategoryModel fromDto(CategoryDTO categoryDTO);

  List<CategoryDTO> toCategoryDtoList(List<CategoryModel> categoryList);
  List<CategoryModel> toCategoryModelList(List<CategoryDTO> categoryDtoList);
}
