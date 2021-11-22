package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.EduCourseQuery;
import com.niluogege.serveredu.entity.vo.CoursePublishVo;
import com.niluogege.serveredu.entity.vo.CourseVo;

import java.util.List;

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

    /**
     * 通过id更新课程
     * @param courseVo
     * @return
     */
    boolean updateCourseById(CourseVo courseVo);

    /**
     * 发布详情
     * @param courseId
     * @return
     */
    CoursePublishVo getCoursePublishVo(String courseId);

    /**
     * 发布课程
     * @param courseId
     * @return
     */
    boolean publishCource(String courseId);

    /**
     * 搜索
     * @param page
     * @param limit
     * @param query
     * @return
     */
    IPage<EduCourse> searchCource(Integer page, Integer limit, EduCourseQuery query);

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    boolean removeCourseById(String courseId);
}
