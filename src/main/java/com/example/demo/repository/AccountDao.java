package com.example.demo.repository;
import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> getAllAccounts();
    List<Account> getAccountsByBank(int bankId);
    Account getAccountById(int accountId);
    void saveAccount(Account account);
    boolean removeAccount(int accountId);
    List<Account> getAccountsByTransaction(int transactionId);
    void transfer(int amount, Connection conn, int fromAccountId,int toAccountId) throws SQLException;

    int depositWithoutTransaction(int amount,Connection conn,int accountId);

    void deposit(int amount,Connection conn,int accountId);
    int getBalance(Connection conn,int accountId);
    int withdraw(int amount, Connection conn, int accountId) throws SQLException;











}
