package io.tince.advanced.java.lambda.expressions;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// When you want to filter/match
public class TestPredicate {
    public static void main(String[] args) {
        // Predicate<T> is a functional interface i.e. one abstract method:
        // boolean test(T t);
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(1));

        System.out.println("-----------------------------------------");

        int x = 4;
        System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0));
        x = 7;
        System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0));

        System.out.println("-----------------------------------------");

        String name = "Mr. Tutku";
        System.out.println("Does " + name + " start with \"Mr.\" ? " + check(name, s -> s.startsWith("Mr.")));
        name = "Ms. Ciko";
        System.out.println("Does " + name + " start with \"Mr.\" ? " + check(name, s -> s.startsWith("Mr.")));

        System.out.println("-----------------------------------------");

        // BiPredicate<T, U> is a functional interface i.e. one abstract method:
        // boolean test(T t, U u);
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Izmir", 5));
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
