package com.budget.budgetmate.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
<<<<<<< Updated upstream

=======
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
>>>>>>> Stashed changes
}
