package com.budget.budgetmate.validation;

import com.budget.budgetmate.dto.request.TransactionDTORequest;

public class PeriodicTransactionValidator extends BasicTransactionValidator {
    public PeriodicTransactionValidator(TransactionDTORequest transactionDTORequest) {
        super(transactionDTORequest);
    }

    @Override
    public void validate() {
        super.validate();
        if (transactionDTORequest.isPeriodic() && transactionDTORequest.getEndDate() != null
                && transactionDTORequest.getTransactionDate().isAfter(transactionDTORequest.getEndDate())) {
            throw new IllegalArgumentException("Дата транзакції перевищує кінцеву дату.");
        }
    }
}
