package com.java.tracker.splitexpense.v1.controller;

import lombok.Data;


@Data
public class LoginRequest {
    private String email;
    private String password;
}
