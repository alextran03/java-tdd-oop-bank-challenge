package com.booleanuk.core.transaction;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final double amount;
    private final TransactionType type;

    public Transaction(LocalDate date, double amount, TransactionType type) {
    this.date = date;
    this.amount = amount;
    this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
