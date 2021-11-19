package com.niluogege.serveredu.controller;


import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.entity.EduVideoForm;
import com.niluogege.serveredu.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin//跨域
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @ApiOperation("获取课程列表")
    @GetMapping("/list")
    public List<EduVideo> getList() {
        return eduVideoService.list(null);
    }

    @GetMapping("/{videoId}")
    @ApiOperation("通过id获取小节")
    public R getById(
            @ApiParam(value = "videoId",required = true) @PathVariable String videoId
    ){
       return R.ok().data(eduVideoService.getById(videoId));
    }

    @ApiOperation("添加小节")
    @PostMapping("/videoId")
    public R add(
            @ApiParam(required = true) @RequestBody EduVideoForm videoForm
    ) {
        return R.simpleReturn(eduVideoService.add(videoForm));
    }


    @ApiOperation("通过id删小节")
    @DeleteMapping("/{videoId}}")
    public R deleteById(
            @ApiParam(required = true) @PathVariable String videoId
    ) {
       return R.simpleReturn(eduVideoService.removeById(videoId));
    }

    @ApiOperation("修改小节")
    @PutMapping("/{videoId}")
    public R updateById(
            @ApiParam(value = "数据",required = true) @RequestBody EduVideoForm videoForm,
            @ApiParam(value = "videoId",required = true) @PathVariable String videoId
    ){
        videoForm.setId(videoId);
        return R.simpleReturn(eduVideoService.updateById(videoForm));
    }
}
