package com.bank.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;

public class AccountService {
    private final AccountRepository repository;
    public AccountService(AccountRepository repository) {
        //TODO Auto-generated constructor stub
        this.repository = repository;
    }
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account handleById(@PathVariable("id") String accId) {
		return repository.findById(accId);
	}

}
