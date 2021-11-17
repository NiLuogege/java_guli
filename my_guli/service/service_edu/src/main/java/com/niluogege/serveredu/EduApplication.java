package com.niluogege.serveredu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.niluogege"})//要拿到 common下的 组件所以需要加上这个
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
