package com.niluogege.servicebase.exceptionhandler;

import com.niluogege.commonutils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    /**
     * 特定异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public R runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        return R.error().message("特定异常处理");
    }

     /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    public R serviceExceptionHandler(ServiceException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }


}
