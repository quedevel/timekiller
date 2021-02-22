package com.inno.backoffice.code.service;

import com.inno.backoffice.code.repository.CodeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CodeService {

    @Resource
    private CodeMapper codeMapper;

}
