package com.bank.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.bank.domain.InsufficientFundsException;
import com.bank.service.TransferService;

public class TransferControllerTest {
    @Test
    public void testHandleTransfer() throws InsufficientFundsException {
        // given
        String srcId = "A123";
        String destId = "B123";
        
        TransferService service = mock(TransferService.class);
        // controller.setService(service);
        
        TransferController controller = new TransferController(service);
        // when
        controller.handleTransfer(srcId, 100d, destId);

        // then
        verify(service).transfer(100d, srcId, destId);
    }
}
