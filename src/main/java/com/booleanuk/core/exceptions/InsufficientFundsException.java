package com.booleanuk.core.exceptions;

public class InsufficientFundsException extends AccountOperationException {
    public InsufficientFundsException(double amount, double balance) {
        super("Cannot withdraw " + amount + " - balance: " + balance);

    }
}
