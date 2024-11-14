package com.budget.budgetmate.repositories;

import com.budget.budgetmate.models.Receipt;
import com.budget.budgetmate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
