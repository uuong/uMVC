package com.framework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/6/26 0026
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }
    public static  boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
    public static boolean isEmpty(Map<?,?> map) {
        return MapUtils.isEmpty(map);
    }
    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }
}
