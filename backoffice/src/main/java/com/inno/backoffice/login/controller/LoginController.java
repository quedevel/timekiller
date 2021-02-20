package com.inno.backoffice.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void login(){
        System.out.println("----------------------- Login -----------------------");
    }

}
