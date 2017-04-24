package org.allen.utility.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 其实Lambda表达式的本质只是一个"语法糖",由编译器推断并帮你转换包装为常规的代码,因此你可以使用更少的代码来实现同样的功能。
 * lambda表达式允许你通过表达式来代替功能接口。
 * lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。
 * 语法: (parameters) -> expression 或 (parameters) ->{ statements; }
 */
public class BasicSample {

    public static void main(String[] args) {
        testForEach();
        testRunnable();
        testComparator();
    }

    public static void testForEach() {
        String[] names = {"张三", "李四", "王五", "赵六"};
        List<String> nameList = Arrays.asList(names);
        nameList.forEach((name) -> System.out.print(name + " "));
        System.out.println();
    }

    public static void testRunnable() {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " is running");
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void testComparator() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"
        };
        Arrays.asList(players).forEach((player) -> System.out.print(player + ";"));
        System.out.println();

        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        Arrays.asList(players).forEach((player) -> System.out.print(player + ";"));
    }
}
