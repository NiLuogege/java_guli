package com.niluogege.serveredu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.niluogege.serveredu.entity.EduSubject;
import com.niluogege.serveredu.entity.ExcelSubjectData;
import com.niluogege.serveredu.service.impl.EduSubjectServiceImpl;

import java.util.Map;

/**
 * AnalysisEventListener 不支持 spring 的依赖注入所以，每次使用都要new 一个 ，如果有需要使用的组件 通过构造方法传进来
 */
public class SubjectExcelListener extends AnalysisEventListener<ExcelSubjectData> {
    private EduSubjectServiceImpl eduSubjectService;

    public SubjectExcelListener(EduSubjectServiceImpl eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        System.out.println("表头信息=" + headMap);

    }

    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {
        System.out.println("invoke=" + excelSubjectData);

        EduSubject one = existSubject(excelSubjectData.getOneSubjectName());//查询一级分类
        if (one==null) {//说明没有该分类需要添加一个
            one = new EduSubject();
            one.setTitle(excelSubjectData.getOneSubjectName()).setParentId("0").setSort(1);
            eduSubjectService.save(one);
        }

        EduSubject two = existSubject(excelSubjectData.getTwoSubjectName(), one.getId());//查询二级分类
        if (two==null){//如果不存在才 插入
            two = new EduSubject();
            two.setTitle(excelSubjectData.getTwoSubjectName()).setParentId(one.getId()).setSort(0);
            eduSubjectService.save(two);
        }
    }

    private EduSubject existSubject(String title) {
        return existSubject(title,"0");
    }

    private EduSubject existSubject(String title,String parentId) {
        return eduSubjectService.getOne(new QueryWrapper<EduSubject>()
                .eq("title", title)
                .eq("parent_id", parentId));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("doAfterAllAnalysed");

    }

}
