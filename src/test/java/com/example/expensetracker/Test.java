package com.example.expensetracker;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import com.example.expensetracker.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TransactionControllerTest {

    @Test
    void testTransactionCreation() {
        Transaction tx = new Transaction();
        tx.setAmount(120.0);
        tx.setDescription("Test expense");
        tx.setDate(LocalDateTime.now());
        tx.setType(TransactionType.EXPENSE);

        assertEquals(120.0, tx.getAmount(), 0.0001);
    }
}


@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void testSaveTransactionToDatabase() {
        Transaction tx = new Transaction();
        tx.setAmount(150.0);
        tx.setDescription("Database test");
        tx.setDate(LocalDateTime.now());
        tx.setType(TransactionType.EXPENSE);

        Transaction saved = transactionRepository.save(tx);

        assertNotNull(saved.getId()); // Проверяем, что ID был сгенерирован (сохранилось)
    }
}