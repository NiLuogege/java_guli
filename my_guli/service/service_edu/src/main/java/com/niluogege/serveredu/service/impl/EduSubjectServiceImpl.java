package com.niluogege.serveredu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduSubject;
import com.niluogege.serveredu.entity.ExcelSubjectData;
import com.niluogege.serveredu.listener.SubjectExcelListener;
import com.niluogege.serveredu.mapper.EduSubjectMapper;
import com.niluogege.serveredu.service.EduSubjectService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Autowired
    private  EduSubjectMapper subjectMapper;

    /**
     * 通过 Excel 导入课程
     *
     * @param file
     */
    @Override
    public void importSubject(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjectData.class, new SubjectExcelListener(this))
                    .sheet()
                    .doRead();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(20002, "导入课程失败");
        }
    }

    @Override
    public List<ExcelSubjectData> downSubjects() {
        List<EduSubject> ones = list(new QueryWrapper<EduSubject>().eq("parent_id", "0"));
        HashMap<String, String> onesMap = new HashMap<>();
        for (EduSubject one : ones) {
            onesMap.put(one.getId(),one.getTitle());
        }

        ArrayList<ExcelSubjectData> list = new ArrayList<>();
        List<EduSubject> twos = list(new QueryWrapper<EduSubject>().ne("parent_id", "0"));
        for (EduSubject two : twos) {
            list.add(new ExcelSubjectData(onesMap.get(two.getParentId()),two.getTitle()));
        }

        return list;
    }

    @Override
    public List<EduSubject> getSubjectsTree() {
      return   subjectMapper.getSubjectsTree();
    }
}
