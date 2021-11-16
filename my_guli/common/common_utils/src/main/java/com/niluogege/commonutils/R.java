package com.niluogege.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    @ApiModelProperty("是否成功")
    private boolean success;
    @ApiModelProperty("返回码")
    private Integer code;
    @ApiModelProperty("描述")
    private String message;
    @ApiModelProperty("返回数据")
    private Map<String,Object> data = new HashMap<>();

    private R() {
    }

    public static R ok(){
        R r = new R();
        r.success=true;
        r.message="success";
        r.code=ResultCode.SUCCESS;
        return r;
    }

    public static R error(){
        R r = new R();
        r.success=false;
        r.message="error";
        r.code=ResultCode.ERROR;
        return r;
    }

    public  R success(boolean success){
        this.success=success;
        return this;
    }


    public  R message(String  message){
        this.message=message;
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<String,Object> map){
        this.data.putAll(map);
        return this;
    }
}
