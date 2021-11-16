package com.niluogege.serveredu.controller;


import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Api(tags = "EduVideoController")
@RestController
@RequestMapping("/serveredu/edu-video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @ApiOperation("获取课程列表")
    @GetMapping("/list")
    public List<EduVideo> getList() {
        return eduVideoService.list(null);
    }

}
