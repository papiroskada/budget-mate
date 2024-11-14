package com.budget.budgetmate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BudgetMateApplicationTests {

	@Test
	void testPasswordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String rawPassword = "newpassword";
		String encodedPassword = "$2a$10$aJplJQC3HpXgKKPoZAMUJeYLo9qhQGBpiwCtHgIfjDwJyLGYok6xK"; // from your database

		System.out.println("Raw password length: " + rawPassword.length());
		System.out.println("Encoded password length: " + encodedPassword.length());
		System.out.println("Password matches: " + passwordEncoder.matches(rawPassword, encodedPassword));

		String newEncodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println("New Encoded Password: " + newEncodedPassword);
	}

}
