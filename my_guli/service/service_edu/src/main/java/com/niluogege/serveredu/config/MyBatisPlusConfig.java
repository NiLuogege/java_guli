package com.niluogege.serveredu.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.niluogege.serveredu.mapper")
@EnableTransactionManagement//支持事务
public class MyBatisPlusConfig {


    @Bean
    @Profile({"dev", "test"})//只在 dev 和test 环境有效
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);//单位ms,如果超过此值则直接报错
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
