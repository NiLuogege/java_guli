package com.niluogege.servercms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.servercms.entity.CrmBanner;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
public interface CrmBannerService extends IService<CrmBanner> {

    Map<String,Object> findByPage(Integer page, Integer limit);
}
