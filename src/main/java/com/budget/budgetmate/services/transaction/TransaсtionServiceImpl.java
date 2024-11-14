package com.budget.budgetmate.services.transaction;

import com.budget.budgetmate.dto.TransactionDTO;
import com.budget.budgetmate.models.Transaction;
import com.budget.budgetmate.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransaсtionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction postTransaction(TransactionDTO transactionDTO) {
        return saveOrUpdateTransaction(new Transaction(), transactionDTO);
    }

    private Transaction saveOrUpdateTransaction(Transaction transaction, TransactionDTO transactionDTO) {
        transaction.setTransactionType(Transaction.TransactionType.valueOf(transactionDTO.getTransactionType()));
        transaction.setTransactionDate(transactionDTO.getDate());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setPeriodic(transactionDTO.isPeriodic());

        return transactionRepository.save(transaction);
    }
}
