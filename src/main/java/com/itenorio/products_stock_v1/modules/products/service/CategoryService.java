package com.itenorio.products_stock_v1.modules.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.itenorio.products_stock_v1.modules.products.repository.CategoryRepository;
import com.itenorio.products_stock_v1.modules.products.schema.Category;

@Service
public class CategoryService {

  @Autowired
  public CategoryRepository categoryRepository;

  public Iterable<Category> getAllCategories() {
    return this.categoryRepository.findAll();
  }

  public Category getCategoryById(Integer id) throws NotFoundException {
    Optional<Category> foundCategory = this.categoryRepository.findById(id);

    if (foundCategory.isEmpty()) {
      throw new NotFoundException();
    }

    return foundCategory.get();
  }

  public Category updateCategory(Category category, Integer id) throws NotFoundException {
    Optional<Category> foundCategory = this.categoryRepository.findById(id);

    if (foundCategory.isEmpty()) {
      throw new NotFoundException();
    }

    Category categoryFound = foundCategory.get();

    if (category.getCategory_name() != null) {
      categoryFound.setCategory_name(category.getCategory_name());
    }

    if (category.getCategory_description() != null) {
      categoryFound.setCategory_description(category.getCategory_description());
    }

    return this.categoryRepository.save(categoryFound);
  }

  public Category addNewCategory(Category category) {
    Category categoryToSave = new Category();
    categoryToSave.setCategory_name(category.getCategory_name());
    categoryToSave.setCategory_description(category.getCategory_description());

    this.categoryRepository.save(categoryToSave);

    return categoryToSave;
  }

  public void deleteCategory(Integer id) throws NotFoundException {
    Optional<Category> foundCategory = this.categoryRepository.findById(id);
    if(foundCategory.isEmpty()) {
      throw new NotFoundException();
    }

    this.categoryRepository.deleteById(id);
  }
}
