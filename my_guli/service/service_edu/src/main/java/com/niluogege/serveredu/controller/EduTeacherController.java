package com.niluogege.serveredu.controller;


import com.niluogege.serveredu.entity.EduTeacher;
import com.niluogege.serveredu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Api(tags = "EduTeacherController")
@RestController
@RequestMapping("/serveredu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation("获取所有讲师")
    @GetMapping("/")
    public List<EduTeacher> list() {
        return teacherService.list(null);
    }


    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("/{id}")
    public boolean removeById(
            @ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id
    ) {
        return teacherService.removeById(id);
    }

}
