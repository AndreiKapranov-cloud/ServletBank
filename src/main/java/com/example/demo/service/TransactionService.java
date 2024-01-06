package com.example.demo.service;

import com.example.demo.dto.BankDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Transaction;
import jakarta.persistence.Id;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getAllTransactions();
    TransactionDto getTransactionById(int transactionId);
    List<TransactionDto>getTransactionsByAccount(int accountId);
    boolean removeTransaction(int transactionId);
}

