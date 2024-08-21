package com.itenorio.products_stock_v1.modules.products.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer category_id;

  @Column(length = 50, nullable = false)
  private String category_name;

  @Column(length = 300)
  private String category_description;

  public Integer getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Integer category_id) {
    this.category_id = category_id;
  }

  public String getCategory_name() {
    return category_name;
  }

  public void setCategory_name(String category_name) {
    this.category_name = category_name;
  }

  public String getCategory_description() {
    return category_description;
  }

  public void setCategory_description(String category_description) {
    this.category_description = category_description;
  }

  public Category() {
  }

  public Category(String id, String name, String description) {
    this.category_id = Integer.parseInt(id);
    this.category_name = name;
    this.category_description = description;
  }
}
