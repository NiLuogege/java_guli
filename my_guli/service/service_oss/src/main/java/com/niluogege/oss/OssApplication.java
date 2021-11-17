package com.niluogege.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


/**
 * 添加 是因为  exclude = DataSourceAutoConfiguration.class
 *
 * spring boot 会默认加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration这个
 * 类，
 * 而DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean，又因为
 * 项目（oss模块）中并没有关于dataSource相关的配置信息，所以当spring创建dataSource bean时因缺
 * 少相关的信息就会报错。
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.niluogege"})//要拿到 common下的 组件所以需要加上这个
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
