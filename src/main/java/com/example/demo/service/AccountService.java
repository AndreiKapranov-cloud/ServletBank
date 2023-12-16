package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Account;
import jakarta.persistence.Id;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    List<AccountDto>getAccountsByBank(int bankId);
    void saveAccount(AccountDto accountDto);
    boolean removeAccount(int AccountId);
    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(int AccountId);

    List<AccountDto> getAccountsByTransaction(int transactionId);

   void transfer(int amount, Connection conn, int fromAccountId, int toAccountId) throws SQLException;

    void deposit(int amount,Connection conn,int AccountId);
    int getBalance(Connection conn,int accountId);
    int withdraw(int amount, Connection conn, int accountId) throws SQLException;


}

