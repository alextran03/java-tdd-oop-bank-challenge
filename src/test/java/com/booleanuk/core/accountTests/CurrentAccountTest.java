package com.booleanuk.core.accountTests;
import com.booleanuk.core.account.CurrentAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentAccountTest {

    @Test
    public void createCurrentAccountTest(){
        CurrentAccount currentAccount = new CurrentAccount();
        assertEquals(0.0, currentAccount.getBalance());
    }
    
}
