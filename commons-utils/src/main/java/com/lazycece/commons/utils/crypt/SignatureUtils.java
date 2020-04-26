package com.lazycece.commons.utils.crypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * for sign param, and all param spilt by '&'
 * <p>
 * eg: param_one=value_one&param_two=value_tow&param_three=value_three
 *
 * @author lazycece
 */
public class SignatureUtils {

    public static String generate(final Map<String, String> map, String key, String... excludes) {
        return generate(map, key, Arrays.asList(excludes));
    }

    public static String generate(final Map<String, String> map, String key, List<String> excludes) {
        Set<String> keySet = map.keySet();
        String[] keyArray = keySet.toArray(new String[0]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (excludes.contains(k)) {
                continue;
            }
            String value = map.get(k);
            if (value != null && value.trim().length() > 0) {
                sb.append(k).append("=").append(map.get(k).trim()).append("&");
            }
        }
        sb.append("key=").append(key);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }
}
