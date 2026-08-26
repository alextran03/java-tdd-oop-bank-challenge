package com.booleanuk.core.accountTests;

import com.booleanuk.core.account.CurrentAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class AccountTest {

    @Test
    public void depositIncreasesBalanceTest() {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(100.0, LocalDate.of(2026, 8, 26));
        assertEquals(100.0, currentAccount.getBalance());
    }
    
}
