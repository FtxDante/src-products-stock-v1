package com.itenorio.products_stock_v1.modules.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itenorio.products_stock_v1.modules.products.schema.Category;
import com.itenorio.products_stock_v1.modules.products.service.CategoryService;

@Controller
@RequestMapping("/api/v1")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping(path = "/category")
  public @ResponseBody Category addNewCategory(@RequestBody Category category) {
    return this.categoryService.addNewCategory(category);
  }

  @GetMapping(path = "/categories")
  public @ResponseBody Iterable<Category> getAllCategories() {
    return this.categoryService.getAllCategories();
  }

  @GetMapping(path = "/category/{id}")
  public @ResponseBody Category getCategoryById(@PathVariable("id") Integer id) throws NotFoundException {
    return this.categoryService.getCategoryById(id);
  }

  @PutMapping(path = "/category/{id}")
  public @ResponseBody Category updateCategory(@RequestBody Category category, @PathVariable("id") Integer id) throws NotFoundException {
    return this.categoryService.updateCategory(category, id);
  }

  @DeleteMapping(path = "/category/{id}")
  public @ResponseBody void deleteCategory(@PathVariable("id") Integer id) throws NotFoundException {
    this.categoryService.deleteCategory(id);
  }
}
