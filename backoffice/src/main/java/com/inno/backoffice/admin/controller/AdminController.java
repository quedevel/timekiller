package com.inno.backoffice.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/adminList")
    public void adminList(){

    }

    @GetMapping("/adminForm")
    public void adminForm(){

    }

}
