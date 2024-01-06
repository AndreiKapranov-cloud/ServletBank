package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.BankDto;
import com.example.demo.entity.Bank;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.BankMapper;
import com.example.demo.repository.AccountDao;
import com.example.demo.repository.BankDao;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService{
    BankMapper bankMapper = new BankMapper();

    private final BankDao bankDao;

    public BankServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }


    @Override
    public BankDto saveBank(BankDto bankDto){
        Bank bank = bankDao.saveBank(bankMapper.toEntity(bankDto));
        return bankMapper.toDto(bank);

    }



    @Override
    public List<BankDto> getAllBanks() {
        return bankDao.getAllBanks()
                .stream()
                .map(bankMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto getBankByAccount(int accountId) {
        return bankMapper.toDto(bankDao.getBankByAccount(accountId));
    }


    @Override
    public boolean updateBank(BankDto bankDTO) {
        try {
        return bankDao.updateBank(bankMapper.toEntity(bankDTO));

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    @Override
    public boolean removeBank(int bankId) {
        return bankDao.removeBank(bankId);
    }
    @Override
    public BankDto getBankById(int bankId) {

        return bankMapper.toDto(bankDao.getBankById(bankId));

    }
}
