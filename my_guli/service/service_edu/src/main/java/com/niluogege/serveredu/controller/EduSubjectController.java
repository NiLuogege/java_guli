package com.niluogege.serveredu.controller;


import com.niluogege.commonutils.R;
import com.niluogege.serveredu.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

}
