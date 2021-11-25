package com.niluogege.servicemsm.controller;


import com.niluogege.commonutils.CacheKeyPrefix;
import com.niluogege.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags = "msm")
@RestController
@RequestMapping("/msm")
public class MsmController {


    @ApiOperation("新增")
    @GetMapping("/")
    public R get() {
        return R.ok();
    }


}
