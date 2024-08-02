package com.java.tracker.splitexpense.v1.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Embeddable
@Table(name = "expense_split")
public class ExpenseSplit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "percentage")
    private BigDecimal percentage;

    // Getters and setters are handled by Lombok's @Data annotation
}
