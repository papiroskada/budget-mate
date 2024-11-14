package com.budget.budgetmate.models;

import com.budget.budgetmate.state.ActiveState;
import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Fund extends Account {

    private Double targetBalance;

    public Fund() {
        super();
        this.setState(new ActiveState()); // Start in active state
    }

    public boolean hasReachedTarget() {
        return this.getBalance() >= this.targetBalance;
    }

    @Override
    public void updateBalance(double amount) {
        super.updateBalance(amount);
        checkTargetBalance();
    }

    private void checkTargetBalance() {
        if (hasReachedTarget()) {
            this.closeAccount();
        }
    }
}
