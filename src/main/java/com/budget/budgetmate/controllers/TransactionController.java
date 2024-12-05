package com.budget.budgetmate.controllers;

import com.budget.budgetmate.dto.request.TransactionDTORequest;
import com.budget.budgetmate.dto.response.TransactionDTOResponse;
import com.budget.budgetmate.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTOResponse> createTransaction(@RequestBody TransactionDTORequest transactionDTORequest) {
        TransactionDTOResponse transactionDTOResponse = transactionService.createTransaction(transactionDTORequest);
        return ResponseEntity.ok(transactionDTOResponse);
    }
}
