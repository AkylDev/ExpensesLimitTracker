package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_category")
public class CategoryModel extends BaseModel{
  private String name;

}
