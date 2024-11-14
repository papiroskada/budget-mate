package com.budget.budgetmate.state;

import com.budget.budgetmate.models.Account;

public class LoanActiveState extends ActiveState {
    @Override
    public void updateBalance(Account account, double amount) {
        account.setBalance(account.getBalance() - Math.abs(amount));
    }

    public void accrueInterest(Account account, double interestRate) {
        double interest = account.getBalance() * interestRate;
        this.updateBalance(account, interest);
    }
}
