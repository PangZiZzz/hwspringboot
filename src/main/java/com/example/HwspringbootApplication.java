package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class HwspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HwspringbootApplication.class, args);
    }

}
