package com.java.tracker.splitexpense.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.java.tracker.splitexpense.v1.model.Expense;
import com.java.tracker.splitexpense.v1.service.ExpenseService;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses/new")
    public String createExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        // Add list of users to the model if needed
        // model.addAttribute("users", userService.getAllUsers());
        return "createExpense";
    }

    @PostMapping("/expenses")
    public String createExpense(@ModelAttribute Expense expense, Model model) {
        try {
            expenseService.addExpense(expense);
            model.addAttribute("message", "Expense added successfully");
            return "success";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "createExpense";
        }
    }
}
