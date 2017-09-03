package org.allen.sample.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Stream是对集合的包装,通常和lambda一起使用。
 * 使用lambdas可以支持许多操作,如 map, filter, limit, sorted, count, min, max, sum, collect 等等。
 */
public class StreamSample {

    static List<Person> persons = new ArrayList<>();

    static {
        Person zhangsan = new Person("张三", 20);
        Person lisi = new Person("李四", 25);
        Person wangwu = new Person("王五", 30);
        Person zhaoliu = new Person("赵六", 35);

        persons.add(zhangsan);
        persons.add(lisi);
        persons.add(wangwu);
        persons.add(zhaoliu);
    }


    public static void main(String[] args) {
        testFilter();
        System.out.println("################");
        testLimit();
        System.out.println("################");
        testSort();
        System.out.println("################");
        testMin();
        System.out.println("################");
        testPredicate();
        System.out.println("################");
        testMap();
        System.out.println("################");
        testReduce();
        System.out.println("################");
        testParalleStream();
    }

    private static void testFilter() {
        persons.stream().filter((person) -> person.getAge() >= 30).forEach((person) -> System.out.println(person.getName() + ", " + person.getAge()));
    }

    private static void testLimit() {
        persons.stream().limit(2).forEach((person) -> System.out.println(person.getName()));
    }

    private static void testSort() {
        // 年龄倒序
        persons.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .forEach((p) -> System.out.println(p.getName() + ", " + p.getAge()));
    }

    private static void testMin() {
        // 年龄最小
        Person person = persons.stream().min((p1, p2) -> p1.getAge() - p2.getAge()).get();
        System.out.println(person.getName() + ", " + person.getAge());
    }

    private static void testPredicate() {
        Predicate<Person> predicate1 = (person) -> person.getAge() >= 20;
        Predicate<Person> predicate2 = (person) -> person.getAge() <= 30;
        persons.stream().filter(predicate1.and(predicate2))
                .forEach((person) -> System.out.println(person.getName() + ", " + person.getAge()));
    }

    private static void testMap() {
        persons.stream().map((person) -> person.getAge() + 1)
                .forEach(System.out::println);
    }

    private static void testReduce() {
        int totalAge = persons.stream().map((person) -> person.getAge())
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalAge);
    }

    private static void testParalleStream() {
        int totalAge = persons.parallelStream().map((person) -> person.getAge())
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalAge);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
