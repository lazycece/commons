package com.lazycece.commons.restful.exception;

import com.lazycece.commons.restful.RespStatus;

/**
 * @author lazycece
 */
public class CommonException extends AbstractCommonException {

    private Integer code = RespStatus.FAIL.getCode();

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
