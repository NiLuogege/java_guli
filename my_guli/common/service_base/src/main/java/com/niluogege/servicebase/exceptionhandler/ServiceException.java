package com.niluogege.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException{
    @ApiModelProperty("错误码")
    private Integer code;
    @ApiModelProperty("错误信息")
    private String msg;
}
