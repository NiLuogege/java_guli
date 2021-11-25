package com.niluogege.serverucenter.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.niluogege.serverucenter.mapper")
@EnableTransactionManagement//支持事务
public class MyBatisPlusConfig {

    /**
     * 性能监控插件
     * @return
     */
    @Bean
    @Profile({"dev", "test"})//只在 dev 和test 环境有效
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);//单位ms,如果超过此值则直接报错
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除
     */
//    @Bean
//    public LogicSqlInjector sqlInjector(){
//        return new LogicSqlInjector();
//    }
}
