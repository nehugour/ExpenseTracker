package com.java.tracker.splitexpense.v1.repository;

import com.java.tracker.splitexpense.v1.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
