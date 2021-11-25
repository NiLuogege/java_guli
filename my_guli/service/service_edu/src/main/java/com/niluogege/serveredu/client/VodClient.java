package com.niluogege.serveredu.client;

import com.niluogege.commonutils.R;
import com.niluogege.serveredu.client.impl.VodClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//指定服务端名称
@FeignClient(value = "service-vod" ,fallback = VodClientImpl.class)
@Component
public interface VodClient {

    /**
     * 声明服务端方法
     * @param videoId
     * @return
     */
    @DeleteMapping("/vod/{videoId}")
    public R removeVideo(@PathVariable("videoId") String videoId);

}
