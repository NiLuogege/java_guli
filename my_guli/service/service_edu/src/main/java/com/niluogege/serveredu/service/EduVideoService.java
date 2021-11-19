package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduVideo;

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
}
