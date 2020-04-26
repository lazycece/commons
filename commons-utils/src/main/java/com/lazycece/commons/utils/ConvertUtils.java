package com.lazycece.commons.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author lazycece
 * @date 2018/4/6
 */
public class ConvertUtils {

    public static List<String> formatList(Object obj) {
        return JSON.parseArray(formatString(obj), String.class);
    }

    public static List<Integer> formatList2Int(Object obj) {
        return JSON.parseArray(formatString(obj), Integer.class);
    }

    public static Integer formatInteger(Object obj) {
        try {
            return Integer.valueOf(formatString(obj));
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer formatInteger(Object obj, Integer d) {
        try {
            String o = formatString(obj);
            if (StringUtils.isBlank(o)) {
                return d;
            }
            return Integer.valueOf(o);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Long formatLong(Object obj) {
        try {
            String value = formatString(obj);
            if (value == null) {
                return null;
            }
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double formatDouble(Object obj) {
        try {
            String value = formatString(obj);
            if (value == null) {
                return null;
            }
            return Double.valueOf(value);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Float formatFloat(Object obj) {
        try {
            String value = formatString(obj);
            if (value == null) {
                return null;
            }
            return Float.valueOf(value);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String formatString(Object obj) {
        try {
            if (obj == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean formatBoolean(Object obj) {
        try {
            if (obj == null) {
                return false;
            }
            return Boolean.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatString(Object obj, String d) {
        try {
            if (obj == null || StringUtils.isBlank(String.valueOf(obj))) {
                return d;
            }
            return String.valueOf(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
