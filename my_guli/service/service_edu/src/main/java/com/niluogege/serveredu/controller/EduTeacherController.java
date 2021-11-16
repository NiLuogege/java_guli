package com.niluogege.serveredu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduTeacher;
import com.niluogege.serveredu.entity.TeacherQuery;
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

    @ApiOperation("分页列表")
    @PostMapping("/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页数量", required = true) @PathVariable Integer limit,
            @ApiParam(name = "teacherQueue", value = "查询对象", required = false) @RequestBody TeacherQuery query
    ) {

        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        IPage<EduTeacher> iPage = teacherService.pageQueue(teacherPage, query);
        return R.ok()
                .data("total", iPage.getTotal())
                .data("list", iPage.getRecords());

    }

    @ApiOperation("获取所有讲师")
    @GetMapping("/")
    public R list() {
        return R.ok().data("item", teacherService.list(null));
    }


    @ApiOperation("根据ID删除讲师")
    @DeleteMapping("/{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id
    ) {
        return R.ok();
    }

}
