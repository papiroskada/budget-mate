package com.budget.budgetmate.services.account;

import com.budget.budgetmate.dto.AccountDTO;
import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.models.User;
import com.budget.budgetmate.repositories.AccountRepository;
import com.budget.budgetmate.services.user.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public Account createAccount(Account account) {
        User currentUser = currentUserService.getCurrentUser();
        account.setUser(currentUser);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        Account existingAccount = getAccountById(id);
        existingAccount.setName(account.getName());
        existingAccount.setBalance(account.getBalance());
        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    @Override
    public Account convertToEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.getName());
        account.setBalance(accountDTO.getBalance());
        account.setState(accountDTO.getState());

        account.setUser(currentUserService.getCurrentUser());

        return account;
    }
}
