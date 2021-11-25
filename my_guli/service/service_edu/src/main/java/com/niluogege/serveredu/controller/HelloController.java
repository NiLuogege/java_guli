package com.niluogege.serveredu.controller;

import com.niluogege.commonutils.R;
import com.niluogege.serveredu.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HelloController")
@RestController
public class HelloController {

    @Autowired
    private EduVideoService eduVideoService;

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hehe() {
        return "fffa";
    }

    @ApiOperation("testSpringClode")
    @GetMapping("/testSpringClode")
    public R testSpringClode(){
        eduVideoService.testSpringClode("aa");
        return R.ok();
    }
}
