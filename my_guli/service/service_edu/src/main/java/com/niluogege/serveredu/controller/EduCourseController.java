package com.niluogege.serveredu.controller;


import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.vo.CourseVo;
import com.niluogege.serveredu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return R.ok().data("id",courseId);
    }


}
