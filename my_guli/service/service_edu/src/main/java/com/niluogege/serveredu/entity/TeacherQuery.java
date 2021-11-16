package com.niluogege.serveredu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "teacher查询对象",description = "讲师查询对象封装")
public class TeacherQuery implements Serializable {

    @ApiModelProperty("教师名称，模糊查询")
    private String name;


    @ApiModelProperty("头衔 1高级讲师 2首席讲师")
    private Integer level;


    @ApiModelProperty(value = "查询开始时间" ,example = "2019-01-01 10:10:10")
    private String begin;//这里传过来的是 String，无需类型转换


    @ApiModelProperty(value = "查询结束时间" ,example = "2019-01-01 10:10:10")
    private String end;
}
