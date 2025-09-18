package com.medico.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;

  @ManyToMany( mappedBy = "categories")
  @JsonIgnore
  private List<Product> products;
}
