package com.niluogege.serveredu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    /**
     * 发布详情
     * @param courseId
     * @return
     */
    CoursePublishVo getCoursePublishVo(@Param("courseId") String courseId);
}
