package com.budget.budgetmate.repositories;

import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.models.Loan;
import com.budget.budgetmate.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
