package kz.junior.task.controller;

import kz.junior.task.dto.CategoryDTO;
import kz.junior.task.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  @PostMapping
  public ResponseEntity<CategoryDTO> createCategory(@RequestBody final CategoryDTO categoryDTO){

    final CategoryDTO savedCategory = categoryService.save(categoryDTO);

    return new ResponseEntity<CategoryDTO>(savedCategory, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> getCategories(){
    return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
  }

}
