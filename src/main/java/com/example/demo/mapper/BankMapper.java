package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.BankDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Bank;

public class BankMapper{
        public Bank toEntity(BankDto dto) {
            Bank bank = new Bank();
            bank.setName(dto.getName());
            bank.setBankId(dto.getBankId());
            bank.setDeleted(dto.getDeleted());
            return bank;
        }


        public BankDto toDto(Bank bank) {
            return BankDto.builder()
                    .name(bank.getName())
                    .bankId(bank.getBankId())
                    .isDeleted(bank.getDeleted())
                    .build();
        }
}
