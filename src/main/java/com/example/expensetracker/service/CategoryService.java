package com.example.expensetracker.service;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> all() {
        return repo.findAll();
    }

    public Category save(Category c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Category get(Long id) {
        return repo.findById(id).orElse(null);
    }
}
