package com.niluogege.serveredu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HelloController")
@RestController
public class HelloController {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hehe() {
        return "fffa";
    }
}
