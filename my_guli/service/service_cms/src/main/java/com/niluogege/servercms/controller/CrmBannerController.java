package com.niluogege.servercms.controller;


import com.niluogege.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
@Api(tags = "CrmBannerController")
@RestController
@RequestMapping("/servercms/crm-banner")
public class CrmBannerController {


    @ApiOperation("/")
    @GetMapping("/")
    public R aa(){
        return R.ok();
    }

}
