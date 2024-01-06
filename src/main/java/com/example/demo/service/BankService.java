package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.BankDto;
import jakarta.persistence.Id;

import java.util.List;

public interface BankService {
    List<BankDto> getAllBanks();
    BankDto saveBank(BankDto bankDto);
    BankDto getBankByAccount(int accountId);
    BankDto getBankById(int bankId);
    boolean updateBank(BankDto bankDTO);

    boolean removeBank(int bankId);
}
