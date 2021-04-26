package com.enjoy.springcloud.exception;

import com.enjoy.springcloud.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hk417
 * @date Created in 2021/4/16 11:51
 * @description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(CustomGlobalException.class)
    public Result error(CustomGlobalException e) {
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }
}
