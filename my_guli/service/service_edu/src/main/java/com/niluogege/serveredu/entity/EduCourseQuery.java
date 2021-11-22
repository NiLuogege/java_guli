package com.niluogege.serveredu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;


@ApiModel("课程搜索对象")
@Data
public class EduCourseQuery implements Serializable {

    @ApiParam(value = "搜索字段-课程标题", required = false)
    @ApiModelProperty(value = "课程标题")
    private String title;

    @ApiModelProperty(value = "课程讲师ID")
    @TableField("teacher_id")
    private String teacherId;

    @ApiModelProperty(value = "二级分类")
    @TableField("subject_id")
    private String subjectId;

    @ApiModelProperty(value = "一级分类")
    @TableField("subject_parent_id")
    private String subjectParentId;

}
