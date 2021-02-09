package com.inno.common.serial.service;

import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.util.SerialGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class SerialIdnService {

    @Resource
    private TcIdsInBaseMapper tcIdsInBaseMapper;

    @Bean(name = "adminSnIdService")
    public SerialGenerator adminSnIdService(){
        return new SerialGenerator("TC_ADMIN_MS","A", tcIdsInBaseMapper);
    }
}
