package com.niluogege.vod.controller;

import com.niluogege.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HelloController")
@RestController
@RequestMapping("/hellow")
public class HelloController {

    @ApiOperation("hello")
    @GetMapping("/")
    public R he(){
        return R.ok();
    }
}
