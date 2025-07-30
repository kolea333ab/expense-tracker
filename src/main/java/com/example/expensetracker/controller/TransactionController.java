package com.example.expensetracker.controller;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import com.example.expensetracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> all(@RequestParam(required = false) TransactionType type,
                                 @RequestParam(required = false) Long categoryId) {
        if (type != null) return service.filterByType(type);
        if (categoryId != null) return service.filterByCategory(categoryId);
        return service.all();
    }

    @PostMapping
    public Transaction add(@RequestBody Transaction tx) {
        return service.save(tx);
    }

    @GetMapping("/{id}")
    public Transaction get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction tx) {
        tx.setId(id);
        return service.save(tx);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
