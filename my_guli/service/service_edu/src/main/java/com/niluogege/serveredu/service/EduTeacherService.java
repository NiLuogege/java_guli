package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduTeacher;
import com.niluogege.serveredu.entity.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 分页加筛选
     * @param teacherPage
     * @param query
     * @return
     */
    IPage<EduTeacher> pageQueue(Page<EduTeacher> teacherPage, TeacherQuery query);
}
