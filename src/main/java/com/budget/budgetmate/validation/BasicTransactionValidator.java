package com.budget.budgetmate.validation;

import com.budget.budgetmate.dto.request.TransactionDTORequest;

public class BasicTransactionValidator implements TransactionValidator {
    protected final TransactionDTORequest transactionDTORequest;

    public BasicTransactionValidator(TransactionDTORequest transactionDTORequest) {
        this.transactionDTORequest = transactionDTORequest;
    }

    @Override
    public void validate() {
        if (transactionDTORequest.getDescription() == null || transactionDTORequest.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Опис транзакції не може бути порожнім.");
        }
        if (transactionDTORequest.getAmount() == null || transactionDTORequest.getAmount() <= 0) {
            throw new IllegalArgumentException("Сума транзакції повинна бути більшою за нуль.");
        }
    }
}
