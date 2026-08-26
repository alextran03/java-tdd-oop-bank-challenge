package com.booleanuk.core.account;

import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.InvalidAmountException;
import com.booleanuk.core.transaction.Transaction;
import com.booleanuk.core.transaction.TransactionType;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Account {
    private String accountNumber;
    private List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount, LocalDate date) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        transactions.add(new Transaction(date, amount, TransactionType.CREDIT));

    }

    public void withdraw(double amount, LocalDate date) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }

        if (!canWithdraw( amount,  date)) {
            throw new InsufficientFundsException(amount, getBalance());
        }
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
        return getBalance() >= amount;
    }

    public String printStatement() {
        List<String[]> rows = new ArrayList<>();
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance = transaction.getType().apply(balance, transaction.getAmount());
            rows.add(new String[]{
                    transaction.getFormattedDate(),
                    transaction.getCreditString(),
                    transaction.getDebitString(),
                    String.format("%.2f", balance)
            });
        }

        Collections.reverse(rows);
        int dateWidth = "date".length();
        int creditWidth = "credit".length();
        int debitWidth = "debit".length();
        int balanceWidth = "balance".length();
        for (String[] row : rows) {
            dateWidth = Math.max(dateWidth, row[0].length());
            creditWidth = Math.max(creditWidth, row[1].length());
            debitWidth = Math.max(debitWidth, row[2].length());
            balanceWidth = Math.max(balanceWidth, row[3].length());
        }

        String format = "%-" + dateWidth + "s || %-" + creditWidth + "s || %-" + debitWidth + "s || %-" + balanceWidth + "s";

        StringBuilder statement = new StringBuilder(
                String.format(format, "date", "credit", "debit", "balance").stripTrailing());
        for (String[] row : rows) {
            statement.append("\n").append(String.format(format, row[0], row[1], row[2], row[3]).stripTrailing());
        }
        return statement.toString();
    }

}

