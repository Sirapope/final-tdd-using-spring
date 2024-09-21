package com.bank.controller;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.bank.domain.Account;
import com.bank.domain.InsufficientFundsException;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;


public class AccountControllerTest {
	@Test
    public void testHandleById() {
    	//given
    	final String accId = "A123";
    	final Account account = new Account(accId, 100d);
    	
    	AccountRepository repository = mock(AccountRepository.class);
    	when(repository.findById(anyString())).thenReturn(account);
		AccountService service = mock(AccountService.class);
    	// controller.setRepository(repository);
    	AccountController controller = new AccountController(service);
    	
    	//when
    	Account result = controller.handleById(accId);
    	
    	//then
    	verify(service, times(1)).handleById(accId);
	}
	
	// @Test
	// public void testHandleTransfer() throws InsufficientFundsException {
    // 	//given
	// 	String srcId = "A123";
	// 	String destId = "B123";
	// 	AccountController controller = new AccountController();
		
	// 	TransferService service = mock(TransferService.class);
	// 	controller.setService(service);
		
    // 	//when
	// 	controller.handleTransfer(srcId, 100d, destId);
		
    // 	//then
	// 	verify(service).transfer(100d, srcId, destId);
	// }
}
