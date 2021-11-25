package com.niluogege.servercms.controller;


import com.niluogege.commonutils.CacheKeyPrefix;
import com.niluogege.commonutils.R;
import com.niluogege.servercms.entity.CrmBanner;
import com.niluogege.servercms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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


    @Cacheable(value = CacheKeyPrefix.BANNER, key = "'list'")
    @GetMapping("/")
    public R list() {
        List<CrmBanner> list = bannerService.list(null);
        return R.ok().data("list", list);
    }

    @Cacheable(value = CacheKeyPrefix.BANNER_TEST, key = "'test'")
    @GetMapping("/test")
    public R listTest() {
        List<CrmBanner> list = bannerService.list(null);
        return R.ok().data("list", list);
    }

}
