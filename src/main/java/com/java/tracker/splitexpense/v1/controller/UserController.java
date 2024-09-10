package com.java.tracker.splitexpense.v1.controller;
import com.java.tracker.splitexpense.v1.model.User;
import com.java.tracker.splitexpense.v1.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController  {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model, HttpSession session) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            model.addAttribute("message", "Login successful");
            model.addAttribute("user", user);
            session.setAttribute("email", user.getEmail()); //It will store the email in session.
            
            return "success"; // Return success.jsp page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Return login.jsp page
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
    	System.out.println("entering /login method @userController");
        return "login";
    }
    
    
}
