package org.allen.sample.currency;

import java.math.BigDecimal;

/**
 * 货币问题
 * float和double只能用来做科学计算或者工程计算,在商业计算中我们要用java.math.BigDecimal
 * 我们如果需要精确计算，非要用String来够造BigDecimal不可！
 */
public class CurrencyTest {

    public static void main(String[] args) {
        double a1 = 0.05;
        double b1 = 0.01;
        System.out.println(a1);   //print: 0.05
        System.out.println(a1 + b1);   //print: 0.060000000000000005


        BigDecimal a2 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(a2.add(b2).doubleValue());    //print: 0.06

        double c1 = 10d;
        double d1 = 3d;
        System.out.println(c1 / d1);    // print: 3.3333333333333335

        BigDecimal c2 = new BigDecimal("10");
        BigDecimal d2 = new BigDecimal("3");
        // 保留2位小数, 四舍五入
        System.out.println(c2.divide(d2, 2, BigDecimal.ROUND_HALF_UP).doubleValue());  // print: 3.33

        //提供指定数值的（精确）小数位四舍五入处理
        double e1 = c1 / d1;
        BigDecimal e2 = new BigDecimal(Double.toString(e1));
        BigDecimal one = new BigDecimal("1");
        System.out.println(e2.divide(one, 2, BigDecimal.ROUND_HALF_UP).doubleValue());  // print: 3.33
    }

}
