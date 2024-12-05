package com.budget.budgetmate.dto.response;

import lombok.Data;

@Data
public class AccountDTOResponse {
    private String name;
    private Double balance;
    private UserShortResponse user;
    private String stateName;
}
