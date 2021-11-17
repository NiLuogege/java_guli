package com.niluogege.serveredu.controller;


import com.alibaba.excel.EasyExcel;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduSubject;
import com.niluogege.serveredu.entity.ExcelSubjectData;
import com.niluogege.serveredu.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/serveredu/edu-subject")
@Api(tags = "EduSubjectController")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;


    @ApiOperation("通过 Excel 导入课程")
    @PostMapping("/addSubject")
    public R addSubject(
            @ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file
    ) {
        subjectService.importSubject(file);
        return R.ok();
    }

    @ApiOperation("导出所有课程分类")
    @GetMapping(value = "/downloadSubjects",produces = "application/octet-stream")
    public void downSubjects(HttpServletRequest request, HttpServletResponse response){
        try {

            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("课程分类.xls","UTF-8"));

            ServletOutputStream outputStream = response.getOutputStream();
            List<ExcelSubjectData> list = subjectService.downSubjects();

            EasyExcel.write(outputStream,ExcelSubjectData.class).sheet("sheet1").doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
