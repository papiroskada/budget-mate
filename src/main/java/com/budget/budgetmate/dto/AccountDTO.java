package com.budget.budgetmate.dto;

import com.budget.budgetmate.models.User;
import com.budget.budgetmate.state.AccountState;
import lombok.Data;

@Data
public class AccountDTO {
    private String name;
    private Double balance;
    private User user;
    private String state;
}
