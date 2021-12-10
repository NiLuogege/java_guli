package com.niluogege.serveredu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduChapter;
import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.service.EduChapterService;
import com.niluogege.serveredu.service.EduVideoService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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


    @ApiOperation("新增章节")
    @PostMapping("/")
    public R addChapter(
            @ApiParam(value = "章节", required = true) @RequestBody EduChapter chapter
    ) {
        if (chapterService.save(chapter)) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("通过id删除章节")
    @DeleteMapping("/{chapterId}")
    public R deleteChapterById(
            @ApiParam(value = "章节id", required = true) @PathVariable String chapterId
    ) {
        boolean result = chapterService.deleteChapterById(chapterId);
        if (result) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation("通过id更新")
    @PutMapping("/")
    public R updateChapterById(
            @ApiParam(value = "对象", required = true) @RequestBody EduChapter chapter
    ) {
//        if (StringUtils.isEmpty(chapter.getId())){
//            throw  new ServiceException(-1,"id 不能为空");
//        }

        if (chapterService.updateById(chapter)) {
            return R.ok();
        }
        return R.error();
    }

}
