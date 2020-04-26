package com.lazycece.commons.utils;


import java.lang.reflect.Method;

/**
 * @author lazycece
 * @date 2019/4/2
 */
public class EnumValidateUtils {

    private static final String ENUM_METHOD_GET_VALUE = "getValue";

    public static <T> T getEnum(Class<T> clazz, Object value) {
        return getEnum(clazz, ENUM_METHOD_GET_VALUE, value);
    }

    public static <T> T getEnum(Class<T> clazz, String enumMethod, Object value) {

        try {
            Method method = clazz.getMethod(enumMethod);
            for (T t : clazz.getEnumConstants()) {
                if (value.equals(method.invoke(t))) {
                    return t;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
