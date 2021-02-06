package com.inno.backoffice.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sample")
@Controller
public class SampleController {

    @GetMapping("/sample")
    public void sample(){}
}
