package com.mroussy.mooviz_back.controller;

import com.mroussy.mooviz_back.exception.CategoryNotFoundException;
import com.mroussy.mooviz_back.exception.MovieNotFoundException;
import com.mroussy.mooviz_back.movie.Category;
import com.mroussy.mooviz_back.movie.Movie;
import com.mroussy.mooviz_back.repository.CategoryRepository;
import com.mroussy.mooviz_back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/addcategory")
    Category newCategory(@RequestBody Category newCategory) { return categoryRepository.save(newCategory);}

    @GetMapping("/getcategories")
    List<Category> getAllCategories() { return categoryRepository.findAll();}

    @GetMapping("/getcategory/{id}")
    Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PutMapping("/updatecategory/{id}")
    Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id){
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @DeleteMapping("deletecategory/{id}")
    String deleteCategory(@PathVariable Long id){
        if(!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        categoryRepository.deleteById(id);
        return "La catégorie avec l'id " + id + " a été correctement supprimée.";
    }
}
