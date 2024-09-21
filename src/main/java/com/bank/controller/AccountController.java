package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.domain.Account;
import com.bank.domain.InsufficientFundsException;
import com.bank.domain.TransferReceipt;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;
import com.bank.service.TransferService;

@Controller
@RequestMapping("/account")
public class AccountController {
	private AccountService service;

	public AccountController(AccountService service2) {
		this.service = service2;
	}

	// public AccountRepository getRepository() {
	// 	return repository;
	// }

	// @Autowired
	// public void setRepository(AccountRepository repository) {
	// 	this.repository = repository;
	// }

	public AccountService getService() {
		return service;
	}

	@Autowired
	public void setService(AccountService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account handleById(@PathVariable("id") String accId) {
		return service.handleById(accId);
	}

	// @RequestMapping(value = "/{srcId}/transfer/{amount}/to/{destId}")
	// public TransferReceipt handleTransfer(@PathVariable("srcId") String srcId,
	// 		@PathVariable("amount") double amount,
	// 		@PathVariable("destId") String destId) throws InsufficientFundsException {
	// 	return service.transfer(amount, srcId, destId);
	// }
}
