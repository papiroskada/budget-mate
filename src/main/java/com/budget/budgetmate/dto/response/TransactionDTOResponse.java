package com.budget.budgetmate.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTOResponse {
    private Long id;
    private String description;
    private Double amount;
    private boolean isPeriodic;
    private LocalDate transactionDate;
    private LocalDate endDate;
    private String transactionType;
    private Long accountId;
}
