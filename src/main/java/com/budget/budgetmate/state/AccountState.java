package com.budget.budgetmate.state;

import com.budget.budgetmate.models.Account;

public interface AccountState {
    void updateBalance(Account account, double amount);
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    void resetBalance(Account account);
}
