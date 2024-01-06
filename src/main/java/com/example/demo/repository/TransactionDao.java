package com.example.demo.repository;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Transaction;
import jakarta.persistence.Id;

import java.util.List;

public interface TransactionDao {
        List<Transaction> getAllTransactions();
        Transaction getTransactionById(int transactionId);
        List<Transaction> getTransactionsByAccount(int AccountId);

        boolean removeTransaction(int transactionId);

}
