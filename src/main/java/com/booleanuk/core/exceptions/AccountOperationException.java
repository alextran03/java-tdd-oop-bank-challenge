package com.booleanuk.core.exceptions;

public abstract class AccountOperationException extends RuntimeException {
    public AccountOperationException(String message) {
        super(message);
    }
}
