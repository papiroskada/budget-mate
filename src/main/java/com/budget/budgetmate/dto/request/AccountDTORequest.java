package com.budget.budgetmate.dto.request;

import com.budget.budgetmate.models.User;
import lombok.Data;

@Data
public class AccountDTORequest {
    private String name;
    private Double balance;
    private Long userId;
    private StateName stateName;
}

