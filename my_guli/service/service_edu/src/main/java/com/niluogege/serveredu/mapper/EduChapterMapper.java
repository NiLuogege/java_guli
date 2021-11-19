package com.niluogege.serveredu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niluogege.serveredu.entity.EduChapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduChapterMapper extends BaseMapper<EduChapter> {

    /**
     * 获取章节 小节的树
     * @return
     */
    List<EduChapter> getChapterTree(@Param("courseId") String courseId);

}
