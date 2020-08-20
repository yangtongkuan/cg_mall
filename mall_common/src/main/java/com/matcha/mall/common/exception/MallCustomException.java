package com.matcha.mall.common.exception;

import com.matcha.mall.common.api.IErrorCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MallCustomException extends RuntimeException {
    private Integer code;
    private String message;

    public MallCustomException() {
    }

    public MallCustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MallCustomException(IErrorCode errorCode) {
        this.code = (int) errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public MallCustomException(IErrorCode errorCode, String message) {
        this.code = (int) errorCode.getCode();
        this.message = message;
    }
}
