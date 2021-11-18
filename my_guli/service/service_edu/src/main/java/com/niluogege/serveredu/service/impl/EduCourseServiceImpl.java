package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduCourse;
import com.niluogege.serveredu.entity.EduCourseDescription;
import com.niluogege.serveredu.entity.vo.CourseVo;
import com.niluogege.serveredu.mapper.EduCourseMapper;
import com.niluogege.serveredu.service.EduCourseDescriptionService;
import com.niluogege.serveredu.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 添加课程
     * @param courseVo
     * @return
     */
    @Override
    public String addCourse(CourseVo courseVo) {

        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseVo,eduCourse);
        //保存课程数据
        save(eduCourse);

        //save 之后 id 就有数据了
        String courseId = eduCourse.getId();

        //保存课程描述
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseVo,eduCourseDescription);
        //使用 课程的id (描述本身就是课程的一部分，之所以拆出来，大概是因为可能数据量会大，影响查询速率)
        eduCourseDescription.setId(courseId);
        courseDescriptionService.save(eduCourseDescription);


        return courseId;
    }

    @Override
    public CourseVo getCourseById(String courseId) {

        CourseVo courseVo = new CourseVo();

        EduCourse eduCourse = getById(courseId);
        BeanUtils.copyProperties(eduCourse,courseVo);

        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);
        BeanUtils.copyProperties(eduCourse,courseDescription);


        return  courseVo;
    }
}
