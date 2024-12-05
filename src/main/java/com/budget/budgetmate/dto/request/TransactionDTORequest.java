package com.budget.budgetmate.dto.request;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTORequest {
    private String description;
    private Double amount;
    private boolean isPeriodic;
    private LocalDate transactionDate;
    private LocalDate endDate;
    private String transactionType; // INCOME or EXPENSE
    private Long accountId;
}
