package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduChapter;
import com.niluogege.serveredu.mapper.EduChapterMapper;
import com.niluogege.serveredu.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduChapterMapper chapterMapper;

    /**
     * 获取章节 小节的树
     * @return
     */
    @Override
    public List<EduChapter> getChapterTree(String courseId) {
       return chapterMapper.getChapterTree(courseId);
    }
}
