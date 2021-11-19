package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.commonutils.R;
import com.niluogege.serveredu.entity.EduChapter;
import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.mapper.EduChapterMapper;
import com.niluogege.serveredu.service.EduChapterService;
import com.niluogege.serveredu.service.EduVideoService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
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


    @Autowired
    private EduVideoService videoService;

    /**
     * 获取章节 小节的树
     *
     * @return
     */
    @Override
    public List<EduChapter> getChapterTree(String courseId) {
        return chapterMapper.getChapterTree(courseId);
    }

    /**
     * 通过id删除
     *
     * @param chapterId
     * @return
     */
    @Override
    public boolean deleteChapterById(String chapterId) {
        Integer count = videoService.getCountByChapterId(chapterId);
        if (count <= 0) {
            return removeById(chapterId);
        } else {
            throw new ServiceException(-1, "该章节下还有小节");
        }
    }
}
