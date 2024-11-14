package com.budget.budgetmate.repositories;

import com.budget.budgetmate.models.Account;
import com.budget.budgetmate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
