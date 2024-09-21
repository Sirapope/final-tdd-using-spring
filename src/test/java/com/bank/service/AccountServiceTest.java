package com.bank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.internal.SimpleAccountRepository;

public class AccountServiceTest {
    @Test
    public void testHandleById() {
        // given
        Account account = new Account("A123", 100d);
        String accId = "A123";
        // SimpleAccountRepository repository = new SimpleAccountRepository();

        AccountRepository repository = mock(AccountRepository.class);
        AccountService service = new AccountService(repository);
        when(repository.findById(anyString())).thenReturn(account);
        Account result = service.handleById(accId);
        verify(repository, times(1)).findById(accId);
        assertFalse(false);
        assertEquals(account, result);

    }
}
