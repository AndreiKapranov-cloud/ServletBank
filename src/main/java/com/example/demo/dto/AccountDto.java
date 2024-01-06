package com.example.demo.dto;



import jdk.jshell.Snippet;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private int balance;
    private int accountId;
    private int bankId;
    private boolean isDeleted;

    public boolean getDeleted() {
        return this.isDeleted;
    }
}