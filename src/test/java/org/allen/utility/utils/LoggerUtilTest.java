package org.allen.utility.utils;

import org.allen.sample.utils.LoggerUtil;
import org.junit.Test;

public class LoggerUtilTest {

    @Test
    public void testInfo() {
        LoggerUtil.info(LoggerUtilTest.class, "info message");
    }

    @Test
    public void testWarn1() {
        LoggerUtil.warn(LoggerUtilTest.class, "warn message");
    }

    @Test
    public void testWarn2() {
        LoggerUtil.warn(LoggerUtil.class, "warn message", new RuntimeException("warn message"));
    }

    @Test
    public void testError1() {
        LoggerUtil.error(LoggerUtil.class, "error message");
    }

    @Test
    public void testError2() {
        LoggerUtil.error(LoggerUtil.class, "error message", new IllegalArgumentException("bad parameter"));
    }
}
