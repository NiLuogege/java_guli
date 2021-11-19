package com.niluogege.serveredu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
public class EduVideoForm implements Serializable {

    @ApiModelProperty(value = "小节ID")
    private String id;

    @ApiModelProperty(value = "小节名称")
    private String title;
    @ApiModelProperty(value = "课程ID")
    private String courseId;
    @ApiModelProperty(value = "章节ID")
    private String chapterId;
    @ApiModelProperty(value = "视频资源")
    private String videoSourceId;
    @ApiModelProperty(value = "显示排序")
    private Integer sort;
    @ApiModelProperty(value = "是否可以试听：0默认 1免费")
    private Boolean free;

}
