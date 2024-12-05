package com.budget.budgetmate.controllers;

import com.budget.budgetmate.dto.request.AccountDTORequest;
import com.budget.budgetmate.dto.response.AccountDTOResponse;
import com.budget.budgetmate.services.account.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {


    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDTOResponse> createAccount(@RequestBody AccountDTORequest accountDTO) {
        try {
            return ResponseEntity.ok(accountService.createAccount(accountDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
