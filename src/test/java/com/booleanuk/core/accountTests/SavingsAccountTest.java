package com.booleanuk.core.accountTests;

import com.booleanuk.core.account.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setUp() {
        savingsAccount = new SavingsAccount();
    }

    @Test
    public void testSavingsAccount() {
        assertEquals(0.0, savingsAccount.getBalance());
    }
    
}
