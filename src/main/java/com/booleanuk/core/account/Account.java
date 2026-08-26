package com.booleanuk.core.account;

import com.booleanuk.core.transaction.Transaction;
import com.booleanuk.core.transaction.TransactionType;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    private String accountNumber;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount, LocalDate date) {
        transactions.add(new Transaction(date, amount, TransactionType.CREDIT));

    }

    public void withdraw(double amount, LocalDate date) {
        transactions.add(new Transaction(date, amount, TransactionType.DEBIT));

    }

    public double getBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance = transaction.getType().apply(balance, transaction.getAmount());
        }
        return balance;

    }

    public boolean canWithdraw(double amount, LocalDate date) {
        return false;
    }

}

