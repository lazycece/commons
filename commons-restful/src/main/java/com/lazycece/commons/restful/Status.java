package com.lazycece.commons.restful;

/**
 * @author lazycece
 */
public interface Status {
    /**
     * Get the associated status code
     *
     * @return the status code
     */
    int getCode();

    /**
     * Get the class of status code
     *
     * @return the class of status code
     */
    RespStatus.Family getFamily();

    /**
     * Get the status's message
     *
     * @return the message
     */
    String getMessage();
}
