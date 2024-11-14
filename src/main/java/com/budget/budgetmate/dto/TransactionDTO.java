package com.budget.budgetmate.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDTO {
    private Long id;
    private String description;
    private Double amount;
    private String transactionType;
    private LocalDate date;
    private boolean isPeriodic;
}
