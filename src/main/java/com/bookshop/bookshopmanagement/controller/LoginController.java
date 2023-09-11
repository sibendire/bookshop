package com.bookshop.bookshopmanagement.controller;

import com.bookshop.bookshopmanagement.service.LoginService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private LoginService loginService;

    public String loginSuccess() {
        return "loginSuccess";
    }
}
