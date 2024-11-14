package com.budget.budgetmate.repositories;

import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.models.Fund;
import com.budget.budgetmate.models.Loan;
import com.budget.budgetmate.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FundRepository extends JpaRepository<Fund, Long> {
}
