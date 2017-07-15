package com.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/6/26 0026
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {
    public static boolean isNotEmpty(String strValue) {
        if (strValue != null) {
            strValue = strValue.trim();
        }
        return StringUtils.isNotEmpty(strValue);
    }
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static String[] splitString(String body, String key) {

        return body.split("key");
    }
}
