package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.entity.EduVideoForm;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduVideoService extends IService<EduVideo> {

    Integer getCountByChapterId(String chapterId);

    boolean add(EduVideoForm videoForm);

    boolean updateById(EduVideoForm videoForm);
}
