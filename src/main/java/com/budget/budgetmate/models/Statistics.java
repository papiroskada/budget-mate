package com.budget.budgetmate.models;

import jakarta.persistence.*;

import java.util.List;

public class Statistics {

    private Double totalIncome;
    private Double totalExpense;

    @ManyToMany
    @JoinTable(name = "statistics_transactions",
            joinColumns = @JoinColumn(name = "statistics_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private List<Transaction> transactions;

    public void calculate(List<Transaction> transactions) {
        // Логіка для підрахунку
    }

}
