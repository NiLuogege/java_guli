package com.niluogege.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 数据库中自动插入 创建时间和 更新时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //这里的 fieldName 是JavaBean中的 属性名 不是 数据库中的列名
        setFieldValByName("gmtCreate", LocalDateTime.now(),metaObject);
        setFieldValByName("gmtModified",LocalDateTime.now(),metaObject);
        setFieldValByName("isDeleted",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("gmtModified",LocalDateTime.now(),metaObject);
    }
}
