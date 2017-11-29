package org.allen.sample.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * System.currentTimeMillis()，该方法的返回值是从1970年1月1日 00:00:00 GMT至当前时间点以来的毫秒数，通常被用来获取当前系统时间；
 */
public class TimeZoneTest {

    public static void main(String[] args) {
        test1();
        System.out.println();

        test2("2017-11-29 21:21:21");
        System.out.println();

        // 差一秒进入夏令时
        test3("2011-03-13 01:59:59");
        System.out.println();

        // 夏令时
        test3("2011-03-13 02:00:00");
        System.out.println();

        // 结束夏令时
        test3("2011-11-06 02:00:01");
    }

    /**
     * 将时间戳转换成不同时区的时间字符串
     */
    private static void test1() {
        Date date = new Date(System.currentTimeMillis());

        TimeZone timeZoneSH = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone timeZoneNY = TimeZone.getTimeZone("America/New_York");

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        outputFormat.setTimeZone(timeZoneNY);
        System.out.println("America/New_York:" + outputFormat.format(date));

        outputFormat.setTimeZone(timeZoneSH);
        System.out.println("Asia/Shanghai:" + outputFormat.format(date));
    }

    /**
     * 将一个以字符串形式输入的北京时间转换成美国东部时间
     */
    private static void test2(String inputDate) {
        TimeZone timeZoneSH = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone timeZoneNY = TimeZone.getTimeZone("America/New_York");
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        inputFormat.setTimeZone(timeZoneSH);
        Date date = null;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.US);
        outputFormat.setTimeZone(timeZoneSH);
        System.out.println("Asia/Shanghai:" + outputFormat.format(date));

        outputFormat.setTimeZone(timeZoneNY);
        System.out.println("America/New_York:" + outputFormat.format(date));
    }

    /**
     * 夏令时(DST)的问题
     * 美国在2011年开始和结束夏令时的时间是：3.13 2AM和11.6 2AM。
     */
    private static void test3(String inputDate) {
        TimeZone timeZoneSH = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone timeZoneNY = TimeZone.getTimeZone("America/New_York");
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        inputFormat.setTimeZone(timeZoneNY);
        Date date = null;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        outputFormat.setTimeZone(timeZoneSH);
        System.out.println("Asia/Shanghai:" + outputFormat.format(date));

        outputFormat.setTimeZone(timeZoneNY);
        System.out.println("America/New_York:" + outputFormat.format(date));
    }
}
