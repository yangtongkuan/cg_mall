package com.matcha.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.matcha.mall.dao"})
public class MallCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallCoreApplication.class, args);
    }
}
