package com.lazycece.commons.restful.exception;

/**
 * @author lazycece
 */
public abstract class AbstractCommonException extends RuntimeException {

    public AbstractCommonException() {
    }

    public AbstractCommonException(String message) {
        super(message);
    }

    public AbstractCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractCommonException(Throwable cause) {
        super(cause);
    }

    /**
     * global-custom-exception's code
     *
     * @return int
     */
    abstract public int getCode();
}
