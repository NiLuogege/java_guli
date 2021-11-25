package com.niluogege.serveredu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.client.VodClient;
import com.niluogege.serveredu.entity.EduVideo;
import com.niluogege.serveredu.entity.EduVideoForm;
import com.niluogege.serveredu.mapper.EduVideoMapper;
import com.niluogege.serveredu.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private VodClient vodClient;

    @Override
    public Integer getCountByChapterId(String chapterId) {
        List<EduVideo> list = list(new QueryWrapper<EduVideo>().eq("chapter_id", chapterId));
        return list == null ? 0 : list.size();
    }

    @Override
    @Transactional
    public boolean removeByChapterId(String chapterId) {
        return removeById(chapterId);
    }

    @Override
    public boolean testSpringClode(String chapterId) {
        vodClient.removeVideo(chapterId);
        return true;
    }

    @Override
    public boolean add(EduVideoForm videoForm) {
        EduVideo eduVideo = new EduVideo();
        BeanUtils.copyProperties(videoForm, eduVideo);
        return save(eduVideo);
    }

    @Override
    public boolean updateById(EduVideoForm videoForm) {
        EduVideo eduVideo = new EduVideo();
        BeanUtils.copyProperties(videoForm, eduVideo);
        return updateById(eduVideo);
    }
}
