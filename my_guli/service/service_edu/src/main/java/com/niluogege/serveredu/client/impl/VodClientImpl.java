package com.niluogege.serveredu.client.impl;

import com.niluogege.commonutils.R;
import com.niluogege.serveredu.client.VodClient;
import org.springframework.stereotype.Component;

/**
 * vod 服务 熔断器（降级策略）
 */
@Component
public class VodClientImpl implements VodClient {
    @Override
    public R removeVideo(String videoId) {
        System.out.println("VodClientImpl time out");
        return R.error().message("time out");
    }
}
