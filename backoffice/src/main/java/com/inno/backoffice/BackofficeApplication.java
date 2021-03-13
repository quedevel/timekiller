package com.inno.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"com.inno.backoffice.**","com.inno.common.**"})
public class BackofficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackofficeApplication.class, args);
    }
}
