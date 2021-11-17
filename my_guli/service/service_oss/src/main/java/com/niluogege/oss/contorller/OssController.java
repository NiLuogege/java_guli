package com.niluogege.oss.contorller;

import com.niluogege.commonutils.R;
import com.niluogege.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "OssController")
@Controller
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private FileService fileService;


    @ApiOperation("oss 上传文件")
    @ResponseBody
    @PostMapping("/upload")
    public R upload(
            @ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file
    ) {
        String url = fileService.uploadFile(file);
        return R.ok().data("url", url);
    }
}
