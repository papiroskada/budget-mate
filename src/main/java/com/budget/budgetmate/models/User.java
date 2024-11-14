package com.budget.budgetmate.models;

import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;


//    public void addAccount(Account account) {
//        accounts.add(account);
//        account.setUser(this); // Зворотне посилання
//    }
//    public void removeAccount(Account account) {
//        accounts.remove(account);
//        account.setUser(null); // Вилучення зворотного посилання
//    }
//    public void viewStatistic() {
//        // Логіка для перегляду статистики
//        System.out.println("Displaying statistics for user: " + username);
//    }
//    public void addExpense(Double amount, String accountName) {
//        // Додаємо витрату на вказаний рахунок
//        for (Account account : accounts) {
//            if (account.getName().equalsIgnoreCase(accountName)) {
//                account.updateBalance(-amount);
//                return;
//            }
//        }
//        System.out.println("Account not found: " + accountName);
//    }
//    public void addIncome(Double amount, String accountName) {
//        // Додаємо дохід на вказаний рахунок
//        for (Account account : accounts) {
//            if (account.getName().equalsIgnoreCase(accountName)) {
//                account.updateBalance(amount);
//                return;
//            }
//        }
//        System.out.println("Account not found: " + accountName);
//    }

}
