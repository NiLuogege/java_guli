package com.niluogege.serveredu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niluogege.serveredu.entity.EduSubject;
import com.niluogege.serveredu.entity.ExcelSubjectData;
import com.niluogege.serveredu.listener.SubjectExcelListener;
import com.niluogege.serveredu.mapper.EduSubjectMapper;
import com.niluogege.serveredu.service.EduSubjectService;
import com.niluogege.servicebase.exceptionhandler.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;

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
}
