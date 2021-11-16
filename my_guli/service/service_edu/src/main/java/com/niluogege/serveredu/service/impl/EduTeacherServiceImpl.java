package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduTeacher;
import com.niluogege.serveredu.entity.TeacherQuery;
import com.niluogege.serveredu.mapper.EduTeacherMapper;
import com.niluogege.serveredu.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    /**
     * 分页加筛选
     *  @param teacherPage
     * @param query
     * @return
     */
    @Override
    public IPage<EduTeacher> pageQueue(Page<EduTeacher> teacherPage, TeacherQuery query) {

        if (query==null){
            query=new TeacherQuery();
        }

        String name = query.getName();
        Integer level = query.getLevel();
        String begin = query.getBegin();
        String end = query.getEnd();

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (level!=null && level > 0) {
            queryWrapper.eq("level", level);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);//大于等于开始时间
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);//小于等于结束时间
        }

        queryWrapper.orderByAsc("sort");
        return page(teacherPage, queryWrapper);
    }
}
