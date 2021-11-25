package com.niluogege.servercms.controller;


import com.niluogege.commonutils.CacheKeyPrefix;
import com.niluogege.commonutils.R;
import com.niluogege.servercms.entity.CrmBanner;
import com.niluogege.servercms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

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
@RequestMapping("/back/banner")
public class BannerBackController {

    @Autowired
    private CrmBannerService bannerService;

    @CacheEvict(value = CacheKeyPrefix.BANNER,allEntries = true)
    @ApiOperation("新增")
    @PostMapping("/")
    public R save(@RequestBody CrmBanner crmBanner) {
        return R.simpleReturn(bannerService.save(crmBanner));
    }


    @CacheEvict(value =  CacheKeyPrefix.BANNER,allEntries = true)
    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public R delete(
            @ApiParam(value = "bannerId", required = true) @PathVariable String id
    ) {
        return R.simpleReturn(bannerService.removeById(id));
    }

    /**
     * allEntries = true 回吧 value 下 所有缓存清掉 ，value 相当于 一个分类
     */
    @CacheEvict(value =  CacheKeyPrefix.BANNER,allEntries = true)
    @ApiOperation("编辑")
    @PutMapping("/")
    public R update(@RequestBody CrmBanner crmBanner) {
        return R.simpleReturn(bannerService.updateById(crmBanner));
    }


    @ApiOperation("分页查询")
    @GetMapping("/{page}/{limit}")
    public R findByPage(
            @ApiParam(value = "当前页码", required = true) @PathVariable Integer page,
            @ApiParam(value = "每页数量", required = true) @PathVariable Integer limit) {
        Map<String, Object> map = bannerService.findByPage(page, limit);
        return R.ok().data(map);
    }
}
