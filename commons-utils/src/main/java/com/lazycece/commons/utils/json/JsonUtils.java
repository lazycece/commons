package com.lazycece.commons.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

public class JsonUtils {

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }

    public static Object parse(String json) {
        return JSON.parse(json);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }
}