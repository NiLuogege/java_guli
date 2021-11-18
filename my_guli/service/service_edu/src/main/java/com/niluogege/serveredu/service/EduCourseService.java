package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.vo.CourseVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程
     * @param courseVo
     * @return
     */
    String addCourse(CourseVo courseVo);

    /**
     * 通过id获取课程
     * @param courseId
     * @return
     */
    CourseVo getCourseById(String courseId);
}
