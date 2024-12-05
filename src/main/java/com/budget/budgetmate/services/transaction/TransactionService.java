package com.budget.budgetmate.service;

import com.budget.budgetmate.dto.request.TransactionDTORequest;
import com.budget.budgetmate.dto.response.TransactionDTOResponse;
import com.budget.budgetmate.models.Transaction;
import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.repositories.TransactionRepository;
import com.budget.budgetmate.repositories.AccountRepository;
import com.budget.budgetmate.validation.BasicTransactionValidator;
import com.budget.budgetmate.validation.PeriodicTransactionValidator;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public TransactionDTOResponse createTransaction(TransactionDTORequest transactionDTORequest) {
        BasicTransactionValidator validator = new PeriodicTransactionValidator(transactionDTORequest);
        validator.validate();

        Account account = accountRepository.findById(transactionDTORequest.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Акаунт не знайдено"));

        Transaction transaction = new Transaction();
        transaction.setDescription(transactionDTORequest.getDescription());
        transaction.setAmount(transactionDTORequest.getAmount());
        transaction.setPeriodic(transactionDTORequest.isPeriodic());
        System.out.println(transactionDTORequest.isPeriodic());
        transaction.setTransactionDate(transactionDTORequest.getTransactionDate());
        transaction.setEndDate(transactionDTORequest.getEndDate());
        transaction.setTransactionType(Transaction.TransactionType.valueOf(transactionDTORequest.getTransactionType()));
        transaction.setAccount(account);

        Transaction savedTransaction = transactionRepository.save(transaction);

        TransactionDTOResponse responseDto = getTransactionDTOResponse(savedTransaction);

        return responseDto;
    }

    private static TransactionDTOResponse getTransactionDTOResponse(Transaction savedTransaction) {
        TransactionDTOResponse responseDto = new TransactionDTOResponse();
        responseDto.setId(savedTransaction.getId());
        responseDto.setDescription(savedTransaction.getDescription());
        responseDto.setAmount(savedTransaction.getAmount());
        responseDto.setPeriodic(savedTransaction.isPeriodic());
        responseDto.setTransactionDate(savedTransaction.getTransactionDate());
        responseDto.setEndDate(savedTransaction.getEndDate());
        responseDto.setTransactionType(savedTransaction.getTransactionType().name());
        responseDto.setAccountId(savedTransaction.getAccount().getId());
        return responseDto;
    }
}
