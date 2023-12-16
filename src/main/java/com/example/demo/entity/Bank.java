package com.example.demo.entity;


import lombok.*;

@Getter @Setter @NoArgsConstructor

@AllArgsConstructor
@Builder
public class Bank{

   private String name;
    private int bankId;
    private boolean isDeleted;

    public boolean getDeleted() {
        return this.isDeleted;
    }
}