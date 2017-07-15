package com.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/6/28 0028
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
public class ArrayUtil {

    public static boolean isNotEmpty(Object[] objects) {
        return ArrayUtils.isNotEmpty(objects);
    }
    public static boolean isEmpty(Object[] objects) {
        return ArrayUtils.isEmpty(objects);
    }
}
