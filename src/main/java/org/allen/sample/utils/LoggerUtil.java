package org.allen.sample.utils;

import org.slf4j.LoggerFactory;

public class LoggerUtil {

    public static void debug(Class clazz, String msg) {
        LoggerFactory.getLogger(clazz).debug(msg);
    }

    public static void info(Class clazz, String msg) {
        LoggerFactory.getLogger(clazz).info(msg);
    }

    public static void warn(Class clazz, String msg) {
        warn(clazz, msg, null);
    }

    public static void warn(Class clazz, String msg, Throwable t) {
        LoggerFactory.getLogger(clazz).warn(msg, t);
    }

    public static void error(Class clazz, String msg) {
        error(clazz, msg, null);
    }

    public static void error(Class clazz, String msg, Throwable t) {
        LoggerFactory.getLogger(clazz).error(msg, t);
    }

}
