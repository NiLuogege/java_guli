package com.niluogege.servercms.controller;


import com.niluogege.commonutils.R;
import com.niluogege.servercms.entity.CrmBanner;
import com.niluogege.servercms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
@Api(tags = "AppBanner")
@RestController
@RequestMapping("/back/banner")
public class BannerAppController {

    @Autowired
    private CrmBannerService bannerService;


    @GetMapping("/")
    public R list(){
        List<CrmBanner> list = bannerService.list(null);
        return R.ok().data("list",list);
    }

}
