package com.budget.budgetmate.services.account;

import com.budget.budgetmate.dto.AccountDTO;
import com.budget.budgetmate.models.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    void deleteAccount(Long id);
    Account convertToEntity(AccountDTO accountDTO);
}
