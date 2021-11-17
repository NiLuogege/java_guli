package com.niluogege.servicebase.exceptionhandler;

import com.niluogege.commonutils.ExceptionUtil;
import com.niluogege.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
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
        log.error(ExceptionUtil.getMessage(e));
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
        log.error(ExceptionUtil.getMessage(e));
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
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }


}
