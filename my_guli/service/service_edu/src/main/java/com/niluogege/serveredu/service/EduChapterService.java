package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduChapter;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduChapterService extends IService<EduChapter> {

    /**
     * 获取章节 小节的树
     * @return
     */
    List<EduChapter> getChapterTree(String courseId);

    /**
     * 通过id删除
     * @param chapterId
     * @return
     */
    boolean deleteChapterById(String chapterId);
}
