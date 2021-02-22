package com.inno.backoffice.code.controller;

import com.inno.backoffice.code.service.CodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/code")
@Controller
public class CodeController {

    @Resource
    private CodeService codeService;

}
