package com.bankinc.bankcinccc.controllers;

import com.bankinc.bankcinccc.controllers.request.AnulationRequest;
import com.bankinc.bankcinccc.controllers.request.PurchaseRequest;
import com.bankinc.bankcinccc.domain.entities.Transaction;
import com.bankinc.bankcinccc.domain.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction/purchase")
    public Transaction makePurchase(@RequestBody PurchaseRequest request) {
        return transactionService.makePurchase(request.getCardId(), request.getPrice());
    }

    @GetMapping("/transaction/{transactionId}")
    public Optional<Transaction> getTransaction(@PathVariable UUID transactionId) {
        return transactionService.getTransaction(transactionId);
    }

    @PostMapping("/transaction/anulation")
    public void annulTransaction(@RequestBody AnulationRequest request) {
        transactionService.annulTransaction(request.getCardId(), request.getTransactionId());
    }
}
