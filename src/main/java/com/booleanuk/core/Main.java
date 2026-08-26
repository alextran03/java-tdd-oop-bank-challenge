package com.booleanuk.core;
import com.booleanuk.core.account.CurrentAccount;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CurrentAccount account = new CurrentAccount();
        account.deposit(150.0, LocalDate.of(2026, 8, 26));
        account.withdraw(100.0, LocalDate.of(2026, 8, 26));
        System.out.println(account.printStatement());
    }
}
