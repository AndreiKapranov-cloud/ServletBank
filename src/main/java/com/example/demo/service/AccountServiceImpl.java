package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.repository.AccountDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService{
    AccountMapper accountMapper = new AccountMapper();

    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {

        this.accountDao = accountDao;
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        return accountDao.getAllAccounts()
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public AccountDto getAccountById(int AccountId) {

        return accountMapper.toDto(accountDao.getAccountById(AccountId));

    }
    @Override
    public List<AccountDto> getAccountsByBank(int bankId) {
        return accountDao.getAccountsByBank(bankId)
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAccount(AccountDto accountDto) {

        accountDao.saveAccount(accountMapper.toEntity(accountDto));
    }

    @Override
    public List<AccountDto> getAccountsByTransaction(int transactionId) {
        return accountDao.getAccountsByTransaction(transactionId)
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public boolean removeAccount(int accountId) {
        return accountDao.removeAccount(accountId);
    }

    @Override
    public void transfer(int amount, Connection conn, int fromAccountId, int toAccountId) throws SQLException {
        accountDao.transfer(amount,conn,fromAccountId,toAccountId);

    }

    @Override
    public void deposit(int amount, Connection conn, int accountId) {
        accountDao.deposit(amount,conn,accountId);
    }

    @Override
    public int getBalance(Connection conn, int accountId) {
        return accountDao.getBalance(conn,accountId);
    }

    @Override
    public int withdraw(int amount, Connection conn, int accountId) throws SQLException {
        return accountDao.withdraw(amount,conn,accountId);
    }
}
