package com.lazycece.commons.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lazycece
 * @date 2019/11/20
 */
public class ClassUtils {

    public static Map<String, Object> toMap(Object object) {
        Objects.requireNonNull(object, "object must not null");
        List<Field> fieldList = FieldUtils.getAllFieldsList(object.getClass());
        Map<String, Object> map = new HashMap<>(fieldList.size());
        fieldList.forEach(field -> {
            try {
                map.put(field.getName(), FieldUtils.readField(field, object, true));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return map;
    }
}
