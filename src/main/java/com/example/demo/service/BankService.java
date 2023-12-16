package com.example.demo.service;

import com.example.demo.dto.BankDto;
import jakarta.persistence.Id;

import java.util.List;

public interface BankService {
    List<BankDto> getAllBanks();

    BankDto getBankByAccount(int accountId);

    boolean updateBank(BankDto bankDTO);

    boolean removeBank(int bankId);
}
