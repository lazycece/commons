package com.lazycece.commons.restful.exception;

import com.lazycece.commons.restful.RespStatus;

/**
 * @author lazycece
 */
public class ParamException extends AbstractCommonException {

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getCode() {
        return RespStatus.PARAM_ERROR.getCode();
    }
}
