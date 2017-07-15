package com.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/14 0014
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class LogUtil {
    public static Logger get() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            return LoggerFactory.getLogger(stack[2].getClassName());

    }
}
