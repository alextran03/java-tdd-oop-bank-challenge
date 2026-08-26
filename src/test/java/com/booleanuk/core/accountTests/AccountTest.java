package com.booleanuk.core.accountTests;

import com.booleanuk.core.account.CurrentAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.TextEvent;
import java.time.LocalDate;

public class AccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    public void setUp() {
        currentAccount = new CurrentAccount();
    }

    @Test
    public void depositIncreasesBalanceTest() {
        currentAccount.deposit(100.0, LocalDate.of(2026, 8, 26));
        assertEquals(100.0, currentAccount.getBalance());
    }

    @Test
    public void withdrawDecreasesBalanceTest() {
        currentAccount.deposit(150.0, LocalDate.of(2026, 8, 26));
        currentAccount.withdraw(100.0, LocalDate.of(2026, 8, 26));
        assertEquals(50, currentAccount.getBalance());
    }

    @Test
    public void testBankStatementprint() {
        currentAccount.deposit(150.0, LocalDate.of(2026, 8, 26));
        currentAccount.withdraw(100.0, LocalDate.of(2026, 8, 26));
        String expected =
                        "date       || credit  || debit  || balance\n" +
                        "26/08/2026 ||         || 100.00 || 50.00\n" +
                        "26/08/2026 || 150.00  ||        || 150.00";

        assertEquals(expected, currentAccount.printStatement());
    }
    
}
