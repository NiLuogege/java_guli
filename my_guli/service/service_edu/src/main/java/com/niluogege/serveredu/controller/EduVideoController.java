package com.niluogege.serveredu.controller;


import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.service.EduVideoService;
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
@RestController
@RequestMapping("/serveredu/edu-video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @GetMapping("/list")
    public List<EduVideo> getList(){
        return eduVideoService.list(null);
    }

}
