package com.niluogege.serveredu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niluogege.serveredu.entity.EduSubject;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduSubjectMapper extends BaseMapper<EduSubject> {

    /**
     * 获取分裂树形结构
     * @return
     */
    List<EduSubject> getSubjectsTree();
}
