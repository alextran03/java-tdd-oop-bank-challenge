package com.booleanuk.core.transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDate date;
    private final double amount;
    private final TransactionType type;

    public Transaction(LocalDate date, double amount, TransactionType type) {
    this.date = date;
    this.amount = amount;
    this.type = type;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getCreditString() {
        return type == TransactionType.CREDIT ? String.format("%.2f", amount) : "";
    }

    public String getDebitString() {
        return type == TransactionType.DEBIT ? String.format("%.2f", amount) : "";
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
