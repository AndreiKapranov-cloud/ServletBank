package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Bank;

import jakarta.persistence.Id;

import java.sql.SQLException;
import java.util.List;

public interface BankDao {
    Bank saveBank(Bank bank);
    List<Bank> getAllBanks();
    Bank getBankByName(String name);
    Bank getBankByAccount(int AccountId);
    boolean updateBank(Bank bank) throws SQLException;
    boolean removeBank(int accountId);
    Bank getBankById(int bankId);
}
