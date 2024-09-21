package com.bank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.domain.InsufficientFundsException;
import com.bank.domain.TransferReceipt;
import com.bank.service.TransferService;

public class TransferController {
    private TransferService service;

    public TransferController(TransferService service2) {
        this.service = service2;
    }

    public void setService(TransferService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{srcId}/transfer/{amount}/to/{destId}")
    public TransferReceipt handleTransfer(@PathVariable("srcId") String srcId,
            @PathVariable("amount") double amount,
            @PathVariable("destId") String destId) throws InsufficientFundsException {
        return service.transfer(amount, srcId, destId);
    }

}
