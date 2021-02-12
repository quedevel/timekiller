package com.inno.backoffice.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/menuList")
    public void menuList(){

    }

    @GetMapping("/menuForm")
    public void menuForm(){

    }
}
