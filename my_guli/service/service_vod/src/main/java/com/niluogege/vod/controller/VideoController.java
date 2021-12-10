package com.niluogege.vod.controller;

import com.niluogege.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "VideoController")
@RestController
@RequestMapping("/vod/video")
public class VideoController {

    @DeleteMapping("/{videoId}")
    public R removeVideo(@PathVariable("videoId") String videoId) {
        System.out.println("vidoId=" + videoId + " 删除成功");
        return R.ok();
    }


    @GetMapping("get-play-auth/{videoId}")
    public R getVideoPlayAuth(
            @PathVariable("videoId") String videoId
    ) {

        //获取阿里云存储相关常量
        String accessKeyId = ConstantVodUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantVodUtils.ACCESS_KEY_SECRET;

        //初始化
//        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(accessKeyId,
//                accessKeySecret);
//        //请求
//        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
//        request.setVideoId(videoId);
//        //响应
//        GetVideoPlayAuthResponse response = client.getAcsResponse(request);
//        //得到播放凭证
//        String playAuth = response.getPlayAuth();
        //返回结果
//        return R.ok().message("获取凭证成功").data("playAuth", playAuth);
        return R.ok();
    }
}
