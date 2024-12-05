package com.budget.budgetmate.services.account;

import com.budget.budgetmate.dto.request.AccountDTORequest;
import com.budget.budgetmate.dto.request.StateName;
import com.budget.budgetmate.dto.response.AccountDTOResponse;
import com.budget.budgetmate.dto.response.UserShortResponse;
import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.models.User;
import com.budget.budgetmate.repositories.AccountRepository;
import com.budget.budgetmate.services.user.UserService;
import com.budget.budgetmate.state.AccountState;
import com.budget.budgetmate.utils.StateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    private UserService userService;

    public AccountDTOResponse createAccount(AccountDTORequest accountDTORequest) {
        User user = userService.findById(accountDTORequest.getUserId());
        StateName stateName = accountDTORequest.getStateName();
        AccountState stateByName = StateUtils.getStateByName(stateName);
       Account account = new Account();
       account.setName(accountDTORequest.getName());
       account.setUser(user);
       account.setBalance(accountDTORequest.getBalance());
       account.setState(stateByName);
       accountRepository.save(account);

        UserShortResponse userShortResponse = new UserShortResponse();
        userShortResponse.setUsername(user.getUsername());
        userShortResponse.setId(user.getId());

        AccountDTOResponse accountDTOResponse = new AccountDTOResponse();
        accountDTOResponse.setName(account.getName());
        accountDTOResponse.setBalance(account.getBalance());
        String StateName = stateName.toString();
        accountDTOResponse.setStateName(StateName);
        accountDTOResponse.setUser(userShortResponse);
        return accountDTOResponse;

    }


}

