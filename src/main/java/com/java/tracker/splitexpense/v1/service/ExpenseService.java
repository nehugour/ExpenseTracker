package com.java.tracker.splitexpense.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.tracker.splitexpense.v1.model.Expense;
import com.java.tracker.splitexpense.v1.model.SplitMethod;
import com.java.tracker.splitexpense.v1.repository.ExpenseRepository;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    
    private HttpSession session;

    public ExpenseService(HttpSession session) {
        this.session = session;
    }

    public void addExpense(Expense expense) {
        validateExpense(expense); // Validate the expense based on the split method

        if (expense.getParticipants() == null) {
            expense.setParticipants(new ArrayList<>());
        }

        switch (expense.getSplitMethod()) {
            case EQUAL:
                handleEqualSplit(expense);
                break;
            case EXACT:
                handleExactSplit(expense);
                break;
            case PERCENTAGE:
                handlePercentageSplit(expense);
                break;
            default:
                throw new IllegalArgumentException("Invalid split method");
        }

        expenseRepository.save(expense);
    }
    
    

   /* private void handleEqualSplit(Expense expense) {
        List<String> participants = expense.getParticipants();
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("At least one participant is required for equal split");
        }
        double splitAmount = expense.getAmount() / participants.size();
        expense.setSplits(participants.stream().collect(Collectors.toMap(participant -> participant, participant -> splitAmount)));
    }*/
    
    //New method with Email in session
    private void handleEqualSplit(Expense expense) {
        String currentUserEmail = (String) session.getAttribute("email");
        System.out.println("Email: "+ currentUserEmail);
        if (currentUserEmail == null || currentUserEmail.isEmpty()) {
            throw new IllegalStateException("Current user email not found in session");
        }

        List<String> participants = expense.getParticipants();
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("At least one participant is required for equal split");
        }

        if (!participants.contains(currentUserEmail)) {
            participants.add(currentUserEmail);
        }

        double splitAmount = expense.getAmount() / participants.size();
        expense.setSplits(participants.stream().collect(Collectors.toMap(participant -> participant, participant -> splitAmount)));
    }

    private void handleExactSplit(Expense expense) {
        validateExactSplit(expense);
        // No additional handling required as validation ensures correctness
    }

    private void handlePercentageSplit(Expense expense) {
        validatePercentageSplit(expense);

        double totalAmount = expense.getAmount();
        expense.getSplits().replaceAll((participant, percentage) -> totalAmount * (percentage / 100.0));
    }
    
    private void validatePercentageSplit(Expense expense) {
        double totalPercentage = expense.getSplits().values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercentage - 100) > 0.01) {
            throw new IllegalArgumentException("Percentages must add up to 100%");
        }
    }

    private void validateExpense(Expense expense) {
        if (expense.getSplitMethod() == SplitMethod.PERCENTAGE) {
            validatePercentageSplit(expense);
        }
    }
    
    
    
    //Added to test

    private void validateExactSplit(Expense expense) {
        double totalExactAmount = expense.getSplits().values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalExactAmount - expense.getAmount()) > 0.01) {
            throw new IllegalArgumentException("Exact amounts must add up to the total expense amount");
        }
    }

    
    
   
}
