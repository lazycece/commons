package com.lazycece.commons.utils.xml;

/**
 * @author lazycece
 * @date 2018/4/6
 */
public class XmlIOException extends RuntimeException {

    public XmlIOException() {
    }

    public XmlIOException(String message) {
        super(message);
    }

    public XmlIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlIOException(Throwable cause) {
        super(cause);
    }
}
