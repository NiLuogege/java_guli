package com.niluogege.serveredu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niluogege.serveredu.entity.EduSubject;
import com.niluogege.serveredu.entity.ExcelSubjectData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author niluogege
 * @since 2021-11-15
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 通过 Excel 导入课程
     */
    void importSubject(MultipartFile file);
    /**
     * 导出Excel
     */
    List<ExcelSubjectData> downSubjects();
}
