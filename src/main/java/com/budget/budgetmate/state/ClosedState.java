package com.budget.budgetmate.state;

import com.budget.budgetmate.models.Account;

public class ClosedState implements AccountState {
    @Override
    public void deposit(Account account, double amount) {
    }
    @Override
    public void updateBalance(Account account, double amount) {

    }
    @Override
    public void withdraw(Account account, double amount) {
    }

    @Override
    public void resetBalance(Account account) {
    }
}

