package com.booleanuk.core.exceptions;

public class InvalidAmountException extends AccountOperationException{
    public InvalidAmountException(double amount) {
        super("Amount must be positive, but was " + amount);
    }

}
