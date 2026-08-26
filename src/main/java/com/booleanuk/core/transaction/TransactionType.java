package com.booleanuk.core.transaction;

public enum TransactionType {
    CREDIT {
        @Override
        public double apply(double balance, double amount) {
            return balance + amount;
        }
    },
    DEBIT {
        @Override
        public double apply(double balance, double amount) {
            return balance - amount;
        }
    };
    public abstract double apply(double balance, double amount);
}
