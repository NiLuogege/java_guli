package com.niluogege.serveredu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel("发布详情")
@Data
public class CoursePublishVo implements Serializable {
    @ApiModelProperty("课程标题")
    private String title;
    @ApiModelProperty("课程封面图")
    private String cover;
    @ApiModelProperty("课程节数")
    private Integer lessonNum;
    @ApiModelProperty("一级分类")
    private String subjectLevelOne;
    @ApiModelProperty("二级分类")
    private String subjectLevelTwo;
    @ApiModelProperty("老师名称")
    private String teacherName;
    @ApiModelProperty("课程价格")
    private BigDecimal price;//只用于显示
}
