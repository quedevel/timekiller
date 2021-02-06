package com.inno.backoffice.sample.service;

import com.inno.backoffice.sample.repository.SampleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SampleService {

    @Resource
    private SampleMapper sampleMapper;

    public String getNow() throws Exception{
        System.out.println("SampleService getNow() : "+ sampleMapper);
        return sampleMapper.getNow();
    }

}
