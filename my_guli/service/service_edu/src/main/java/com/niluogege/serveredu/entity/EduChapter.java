package com.niluogege.serveredu.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_chapter")
@ApiModel(value="EduChapter对象", description="课程")
public class EduChapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "章节ID")
    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "课程ID")
    @TableField("course_id")
    private String courseId;

    @ApiModelProperty(value = "章节名称")
    private String title;

    @ApiModelProperty(value = "显示排序")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;


    @ApiModelProperty("小节")
    @TableField(exist = false)
    private List<EduVideo> children;

}
