package com.budget.budgetmate.models;

import com.budget.budgetmate.state.AccountState;
import com.budget.budgetmate.state.ActiveState;
import com.budget.budgetmate.state.ClosedState;
import com.budget.budgetmate.state.FrozenState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Transient
    private AccountState state;

    public Account() {
        this.state = new ActiveState();
    }

    public void updateBalance(double amount) {
        state.updateBalance(this, amount);
    }

    public void deposit(double amount) {
        state.deposit(this, amount);
    }
    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }
    public void resetBalance() {
        state.resetBalance(this);
    }
    public void activateAccount() {
        this.setState(new ActiveState());
    }
    public void freezeAccount() {
        this.setState(new FrozenState());
    }
    public void closeAccount() {
        this.setState(new ClosedState());
    }

}

