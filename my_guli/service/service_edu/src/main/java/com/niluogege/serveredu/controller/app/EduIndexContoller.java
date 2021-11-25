package com.niluogege.serveredu.controller.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduChapter;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.EduTeacher;
import com.niluogege.serveredu.service.EduChapterService;
import com.niluogege.serveredu.service.EduCourseService;
import com.niluogege.serveredu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@CrossOrigin
@RequestMapping("/app")
@RestController
@Api(tags = "APP")
public class EduIndexContoller {

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("/home")
    @ApiOperation("首页数据")
    public R index() {
        //8个课程
        List<EduCourse> courses = courseService.list(new QueryWrapper<EduCourse>().orderByDesc("id").last("limit 2"));
        List<EduTeacher> teachers = teacherService.list(new QueryWrapper<EduTeacher>().orderByDesc("level").last("limit 4"));

        return R.ok().data("courses", courses).data("teachers", teachers);
    }
}
