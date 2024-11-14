package com.budget.budgetmate.services.transaction;

import com.budget.budgetmate.dto.TransactionDTO;
import com.budget.budgetmate.models.Transaction;

public interface TransactionService {
    Transaction postTransaction(TransactionDTO transactionDTO);

}
