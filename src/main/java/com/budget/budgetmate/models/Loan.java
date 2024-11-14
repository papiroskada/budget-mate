package com.budget.budgetmate.models;

import com.budget.budgetmate.state.ClosedState;
import com.budget.budgetmate.state.LoanActiveState;
import jakarta.persistence.*;

@Entity
public class Loan extends Account {
    @Column(nullable = false)
    private double interestRate;

    public Loan() {
        super();
        this.setState(new LoanActiveState());
    }

    public void accrueInterest() {
        ((LoanActiveState) this.getState()).accrueInterest(this, this.interestRate);
    }

    @Override
    public void updateBalance(double amount) {
        super.updateBalance(-Math.abs(amount));
        checkAndCloseLoan();
    }
    public void checkAndCloseLoan() {
        if (this.getBalance() >= 0) {
            this.setState(new ClosedState());
        }
    }
}

