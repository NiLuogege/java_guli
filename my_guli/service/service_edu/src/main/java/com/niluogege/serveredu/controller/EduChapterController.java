package com.niluogege.serveredu.controller;


import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduChapter;
import com.niluogege.serveredu.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Api(tags = "EduChapterController")
@RestController
@RequestMapping("/serveredu/edu-chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    @GetMapping("/")
    @ApiOperation("获取章节 小节的树")
    public R getChapterTree(
            @ApiParam(value = "课程id,不传获取所有", required = false)
            @RequestParam(value = "courseId", required = false) String courseId
    ) {

        List<EduChapter> list = chapterService.getChapterTree(courseId);

        return R.ok().data(list);
    }


}
