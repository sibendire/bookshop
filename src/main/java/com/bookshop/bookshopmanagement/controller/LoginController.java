package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private LoginService loginService;
@GetMapping("/login")
    public String loginSuccess() {
        return "login";
    }
}
