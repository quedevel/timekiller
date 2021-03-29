package com.inno.common;

import com.inno.common.constant.CommonConstants;
import com.inno.common.util.SerialGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.inno.common.util","com.inno.common.**.repository","com.inno.common.**.service"})
@SpringBootApplication
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }


    /**
     * TC_ADMIN_MS 일련번호
     * @return
     */
    @Bean(name = "adminSnIdService")
    public SerialGenerator adminSnIdService(){
        return new SerialGenerator(CommonConstants.TC_ADMIN_MS.name(), CommonConstants.TC_ADMIN_MS.getValue());
    }

    /**
     * TC_AUTH_MS 일련번호
     * @return
     */
    @Bean(name = "authSnIdService")
    public SerialGenerator authSnIdService(){
        return new SerialGenerator(CommonConstants.TC_AUTH_MS.name(), CommonConstants.TC_AUTH_MS.getValue());
    }

    /**
     * TC_ADMIN_MENU_LS 일련번호
     * @return
     */
    @Bean(name = "menuSnIdService")
    public SerialGenerator menuSnIdService(){
        return new SerialGenerator(CommonConstants.TC_ADMIN_MENU_LS.name(), CommonConstants.TC_ADMIN_MENU_LS.getValue());
    }
}
