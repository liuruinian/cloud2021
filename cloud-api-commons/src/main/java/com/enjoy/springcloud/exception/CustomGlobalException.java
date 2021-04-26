package com.enjoy.springcloud.exception;

import com.enjoy.springcloud.result.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hk417
 * @date Created in 2021/4/11 17:47
 * @description 自定义全局异常类
 */
@Data
@ApiModel("自定义全局异常类")
public class CustomGlobalException extends RuntimeException{

    @ApiModelProperty(value = "异常状态码")
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public CustomGlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public CustomGlobalException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CustomGlobalException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
