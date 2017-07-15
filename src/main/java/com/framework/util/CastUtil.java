package com.framework.util;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/6/26 0026
 * Time: 13:09
 * To change this template use File | Settings | File Templates.
 */
public class CastUtil {
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, int i) {
        double doubleValue = i;
        if (obj != null) {
            String strValue = castString(obj);
            if(StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = i;
                }

            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }

    public static long castLong(Object obj, int i) {
        long longValue = i;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = i;
                }
            }
        }
        return longValue;
    }

    public static int castInt(Object obj) {
        return castInt(obj, 0);
    }

    public static int castInt(Object obj, int i) {
        int intValue = i;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = i;
                }
            }
        }
        return intValue;
    }

    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj,false);
    }

    public static boolean castBoolean(Object obj, boolean b) {
        boolean booleanValue = b;
        if (obj != null) {
            booleanValue = Boolean.parseBoolean(castString(obj));
        }
        return booleanValue;
    }
}
