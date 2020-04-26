package com.lazycece.commons.utils;

import java.math.BigDecimal;

/**
 * @author lazycece
 */
public class MathUtils {

    /**
     * To formal ths data, retain length digits after the decimal point
     *
     * @param length
     * @param value
     * @return
     */
    public static double formal(int length, double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(length, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}