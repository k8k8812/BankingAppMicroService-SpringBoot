package com.ying.chen.springproject.BankingAppMicroServiceSpringboot.model;

import java.math.BigDecimal;
import java.util.List;

public abstract class Account {

    private BigDecimal current_balance;
    private BigDecimal previous_balance;
    private List<String> history;
    private String action;

    public Account(){}
    public Account(BigDecimal current_balance, BigDecimal previous_balance, String action) {
        this.current_balance = current_balance;
        this.previous_balance = previous_balance;
        this.action = action;
    }

    public BigDecimal withdraw(BigDecimal withdraw){
        return this.current_balance;
    }

    public BigDecimal deposit(BigDecimal deposit){
        return this.current_balance;
    }

    public void viewHistory(){
        for(String item : this.history){
            System.out.println(item);
        }
    }
}
