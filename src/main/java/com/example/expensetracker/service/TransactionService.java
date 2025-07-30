package com.example.expensetracker.service;

import com.example.expensetracker.model.*;
import com.example.expensetracker.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> all() {
        return repo.findAll();
    }

    public Transaction get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Transaction save(Transaction tx) {
        return repo.save(tx);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Transaction> filterByType(TransactionType type) {
        return repo.findByType(type);
    }

    public List<Transaction> filterByCategory(Long categoryId) {
        return repo.findByCategory_Id(categoryId);
    }
}

