package com.java.tracker.splitexpense.v1.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Return a custom error page
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}
