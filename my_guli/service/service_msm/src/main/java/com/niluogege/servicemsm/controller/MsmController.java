package com.niluogege.servicemsm.controller;


import com.niluogege.commonutils.R;
import com.niluogege.commonutils.RandomUtil;
import com.niluogege.servicemsm.service.MsmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;


@Api(tags = "msm")
@RestController
@RequestMapping("/api/msm")
public class MsmController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MsmService msmService;

    @ApiOperation("新增")
    @GetMapping("/send/{phone}")
    public R send(
            @ApiParam(value = "手机号", required = true) @PathVariable String phone
    ) {

        if (StringUtils.isEmpty(phone)) {
            return R.error().message("手机号为空");
        }
        String cacheCode = (String) redisTemplate.boundValueOps("sendLoginMsm_"+phone).get();
        if (!StringUtils.isEmpty(cacheCode)) {
            return R.ok();
        }


        String code = RandomUtil.getSixBitRandom();

        boolean result = msmService.send(phone, code);
        if (result) {
            redisTemplate.boundValueOps("sendLoginMsm_"+phone).set(code,5, TimeUnit.MINUTES);
            return R.ok();
        }

        return R.error().message("短信发送失败");
    }


}
