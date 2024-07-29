package com.java.tracker.splitexpense.v1.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;

    @Enumerated(EnumType.STRING)
    private SplitMethod splitMethod;

    @ElementCollection
    @CollectionTable(name = "expense_split", joinColumns = @JoinColumn(name = "expense_id"))
    @MapKeyColumn(name = "user_email")
    @Column(name = "amount")
    private Map<String, Double> splits = new HashMap<>(); // Stores amount or percentage split

    @ElementCollection
    @CollectionTable(name = "expense_participants", joinColumns = @JoinColumn(name = "expense_id"))
    @Column(name = "participant_email")
    private List<String> participants = new ArrayList<>();// Stores emails of participants

    // Getters and setters
}
