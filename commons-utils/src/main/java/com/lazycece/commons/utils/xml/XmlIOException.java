package com.lazycece.commons.utils.xml;

/**
 * @author CC
 * 2018.04.06
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
