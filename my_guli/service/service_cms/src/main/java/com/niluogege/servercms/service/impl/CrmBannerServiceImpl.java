package com.niluogege.servercms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.servercms.entity.CrmBanner;
import com.niluogege.servercms.mapper.CrmBannerMapper;
import com.niluogege.servercms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {
    @Autowired
    private CrmBannerMapper bannerMapper;

    @Override
    public Map<String,Object> findByPage(Integer page, Integer limit) {
        Page<CrmBanner> bannerPage = new Page<>(page, limit);
        IPage<CrmBanner> iPage = bannerMapper.selectPage(bannerPage, null);
        HashMap<String, Object> map = new HashMap<>();

        System.out.println("getTotal="+iPage.getTotal()+" getSize="+iPage.getSize()+" getCurrent="+iPage.getCurrent());

        map.put("list",iPage.getRecords());
        map.put("total",iPage.getTotal());
        return map;
    }
}
