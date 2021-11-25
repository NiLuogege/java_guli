package com.niluogege.vod.controller;

import com.niluogege.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "HelloController")
@RestController
@RequestMapping("/vod")
public class HelloController {

    @ApiOperation("hello")
    @GetMapping("/")
    public R he(){
        return R.ok();

    }
    @DeleteMapping("/{videoId}")
    public R removeVideo(@PathVariable("videoId") String videoId){
        System.out.println("vidoId="+videoId +" 删除成功");
        return R.ok();
    }
}
