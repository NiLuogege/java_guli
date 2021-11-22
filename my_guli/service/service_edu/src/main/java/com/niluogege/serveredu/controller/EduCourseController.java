package com.niluogege.serveredu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.EduCourseQuery;
import com.niluogege.serveredu.entity.vo.CoursePublishVo;
import com.niluogege.serveredu.entity.vo.CourseVo;
import com.niluogege.serveredu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/serveredu/edu-course")
@CrossOrigin//解决跨域问题
@Api(tags = "EduCourseController")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @ApiOperation("添加课程")
    @PostMapping("/")
    public R addCourse(
            @ApiParam(name = "courseVo", value = "课程", required = true) @RequestBody CourseVo courseVo
    ) {
        String courseId = courseService.addCourse(courseVo);
        return R.ok().data("id", courseId);
    }

    @ApiOperation("通过id 获取课程详情")
    @GetMapping("/{id}")
    public R getCourseById(
            @ApiParam(value = "课程id", required = true) @PathVariable String id
    ) {

        CourseVo vo = courseService.getCourseById(id);
        return R.ok().data(vo);
    }


    @ApiOperation("通过id更新课程")
    @PutMapping("/")
    public R updateCourseById(
            @ApiParam(value = "course", required = true) @RequestBody CourseVo courseVo
    ) {
        boolean result = courseService.updateCourseById(courseVo);
        if (result) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation("发布详情")
    @GetMapping("/publish/{courseId}")
    public R getCoursePublishVo(
            @ApiParam(value = "courseId", required = true) @PathVariable String courseId
    ) {
        CoursePublishVo result = courseService.getCoursePublishVo(courseId);
        return R.ok().data(result);
    }


    @ApiOperation("发布课程")
    @PostMapping("/publish/{courseId}")
    public R publishCource(
            @ApiParam(value = "courseId", required = true) @PathVariable() String courseId
    ) {
        boolean result = courseService.publishCource(courseId);
        return R.simpleReturn(result);
    }


    @ApiOperation("搜索")
    @GetMapping("/{page}/{limit}")
    public R searchCource(
            @ApiParam(value = "当前页", required = true) @PathVariable Integer page,
            @ApiParam(value = "每页数量", required = true) @PathVariable Integer limit,
            @ApiParam(value = "查询对象") EduCourseQuery query
    ) {

        IPage<EduCourse> list = courseService.searchCource(page, limit, query);
        return R.ok().data("list", list.getRecords()).data("total", list.getTotal());
    }
}
