package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.EduCourseDescription;
import com.niluogege.serveredu.entity.EduCourseQuery;
import com.niluogege.serveredu.entity.vo.CoursePublishVo;
import com.niluogege.serveredu.entity.vo.CourseVo;
import com.niluogege.serveredu.mapper.EduCourseMapper;
import com.niluogege.serveredu.service.EduChapterService;
import com.niluogege.serveredu.service.EduCourseDescriptionService;
import com.niluogege.serveredu.service.EduCourseService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private EduCourseMapper courseMapper;

    /**
     * 添加课程
     *
     * @param courseVo
     * @return
     */
    @Override
    @Transactional
    public String addCourse(CourseVo courseVo) {

        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseVo, eduCourse);
        //保存课程数据
        save(eduCourse);

        //save 之后 id 就有数据了
        String courseId = eduCourse.getId();

        //保存课程描述
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseVo, eduCourseDescription);
        //使用 课程的id (描述本身就是课程的一部分，之所以拆出来，大概是因为可能数据量会大，影响查询速率)
        eduCourseDescription.setId(courseId);
        courseDescriptionService.save(eduCourseDescription);


        return courseId;
    }

    /**
     * 通过id获取课程
     *
     * @param courseId
     * @return
     */
    @Override
    @Transactional
    public CourseVo getCourseById(String courseId) {

        CourseVo courseVo = new CourseVo();

        EduCourse eduCourse = getById(courseId);
        if (eduCourse != null) {
            BeanUtils.copyProperties(eduCourse, courseVo);
        }

        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        if (courseDescription != null) {
            BeanUtils.copyProperties(courseDescription, courseVo);
        }


        return courseVo;
    }

    /**
     * 通过id更新课程
     *
     * @param courseVo
     * @return
     */
    @Override
    @Transactional
    public boolean updateCourseById(CourseVo courseVo) {

        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseVo, eduCourse);

        //更逊课程
        boolean result1 = updateById(eduCourse);
        if (!result1) {
            throw new ServiceException(-1, "更逊课程失败");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseVo, eduCourseDescription);
        //更逊描述
        boolean result2 = courseDescriptionService.updateById(eduCourseDescription);

        if (!result2) {
            throw new ServiceException(-1, "更逊描述失败");
        }

        return result1 && result2;
    }

    /**
     * 发布详情
     *
     * @param courseId
     * @return
     */
    @Override
    public CoursePublishVo getCoursePublishVo(String courseId) {
        return courseMapper.getCoursePublishVo(courseId);

    }

    /**
     * 发布课程
     *
     * @param courseId
     * @return
     */
    @Override
    public boolean publishCource(String courseId) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setStatus("Normal");
        return updateById(eduCourse);
    }

    /**
     * 搜索
     *
     * @param page
     * @param limit
     * @param query
     * @return
     */
    @Override
    public IPage<EduCourse> searchCource(Integer page, Integer limit, EduCourseQuery query) {
        String title = query.getTitle();
        String teacherId = query.getTeacherId();
        String subjectId = query.getSubjectId();
        String subjectParentId = query.getSubjectParentId();


        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            queryWrapper.like("title", title);
        }

        if (!StringUtils.isEmpty(teacherId)) {
            queryWrapper.eq("teacher_id", teacherId);
        }

        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.eq("subject_parent_id", subjectParentId);
        }

        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.eq("subject_id", subjectId);
        }

        Page<EduCourse> p = new Page<EduCourse>(page, limit);
        IPage<EduCourse> coursePage = page(p, queryWrapper);
        return coursePage;
    }

    @Override
    @Transactional
    public boolean removeCourseById(String courseId) {

        //删除章节
        boolean deleteChapter = chapterService.deleteChapterById(courseId);
        if (!deleteChapter) {
            throw new ServiceException(-1, "删除章节失败");
        }

        //删除描述
        boolean deleteDescription = courseDescriptionService.removeById(courseId);
        if (!deleteDescription) {
            throw new ServiceException(-1, "删除描述失败");
        }

        //删除课程
        boolean removeCourse = removeById(courseId);
        if (!removeCourse) {
            throw new ServiceException(-1, "删除课程失败");
        }
        return true;
    }
}
