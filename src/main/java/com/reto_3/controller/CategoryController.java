package com.reto_3.controller;


import com.reto_3.entity.Category;
import com.reto_3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category postCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
}
