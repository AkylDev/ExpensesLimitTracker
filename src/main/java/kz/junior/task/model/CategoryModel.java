package kz.junior.task.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "t_category")
public class CategoryModel extends BaseModel{
  private String name;

}
