package com.niluogege.serveredu.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@ApiModel("excel 映射实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Accessors(chain = true)  easyExcel不支持  @Accessors(chain = true)
public class ExcelSubjectData {

    @ExcelProperty("一级分类")//指定列
    private String oneSubjectName;


    @ExcelProperty("二级分类")//指定列
    private String twoSubjectName;


}
