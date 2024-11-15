package com.budget.budgetmate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Transaction implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private boolean isPeriodic;

    @Column(nullable = false)
    private LocalDate transactionDate;

    @Column
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    public enum TransactionType {
        INCOME, EXPENSE
    }

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Override
    public Transaction clone() {
        try {
            Transaction clonedTransaction = (Transaction) super.clone();
            clonedTransaction.id = null;
            clonedTransaction.transactionDate = this.transactionDate.plusMonths(1);
            if (this.endDate != null && clonedTransaction.transactionDate.isAfter(this.endDate)) {
                return null;
            }

            return clonedTransaction;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Клонування не підтримується", e);
        }
    }

    public Transaction createNextPeriodicTransaction() {
        if (!this.isPeriodic) {
            throw new IllegalStateException("Ця транзакція не є періодичною.");
        }
        if (this.endDate != null && this.transactionDate.plusMonths(1).isAfter(this.endDate)) {
            throw new IllegalStateException("Транзакція перевищує дату закінчення.");
        }
        return this.clone();
    }
}
