package com.booleanuk.core.account;

import com.booleanuk.core.transaction.Transaction;

import java.time.LocalDate;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private List<Transaction> transactions;

    public void deposit(double amount, LocalDate date) {

    }

    public void withdraw(double amount, LocalDate date) {

    }

    public double getBalance() {
        return 0;

    }

    public boolean canWithdraw(double amount, LocalDate date) {
        return false;
    }

}

