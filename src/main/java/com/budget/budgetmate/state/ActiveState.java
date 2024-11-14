package com.budget.budgetmate.state;

import com.budget.budgetmate.models.Account;

public class ActiveState implements AccountState {
    @Override
    public void updateBalance(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }
    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
    }

    @Override
    public void resetBalance(Account account) {
        account.setBalance(0.0);
    }
}

