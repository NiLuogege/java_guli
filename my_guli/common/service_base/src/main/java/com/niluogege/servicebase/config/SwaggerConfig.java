package com.niluogege.servicebase.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("接口文档 groupName")
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.niluogege.server.controller"))
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))//所有不包含带有 admin 的路径
                .paths(Predicates.not(PathSelectors.regex("/error/.*")))//所有不包含带有 error 的路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档 title")
                .description("接口文档 description")
                .contact(new Contact("niluogege", "http://localhost:8081/doc.html", "niluogege@qq.com"))
                .version("1.0")
                .build();
    }
}
