package com.inno.backoffice.sample.controller;

import com.inno.backoffice.sample.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/sample")
@Controller
public class SampleController {

    @Resource
    private SampleService sampleService;

    @GetMapping("/sample")
    public void sample() throws Exception{
        System.out.println("Sample.......................................");
        System.out.println(sampleService.getNow());
        System.out.println(".............................................");
    }
}
