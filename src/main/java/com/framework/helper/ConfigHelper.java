package com.framework.helper;

import com.framework.util.Constant;
import com.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/15 0015
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps("config.properties");
    public  static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, Constant.APP_BASE_PACKAGE);
    }
    /**
     * 获取JSP路径
     *
     * @return
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, Constant.APP_JSP_PATH, "/WEB-INF/jsp/");
    }

    /**
     * 获取应用静态资源路径
     *
     * @return
     */
    public static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, Constant.APP_ASSET_PATH, "/asset/");
    }
}
