package io.tince.advanced.java.section01.lambda.expressions;

import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        // Predicate<T> is a functional interface i.e. one abstract method: boolean test(T t);
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1)); // true
        System.out.println("Predicate: " + predicate.test(1));  // false

        int x = 4;
        System.out.printf("\nIs %s even? %s", x, check(4, n -> n % 2 == 0));    // true
        x = 7;
        System.out.printf("\nIs %s even? %s", x, check(7, n -> n % 2 == 0));    // false

        String name = "Mr. Joe Blogss";
        System.out.printf("\nDoes %s start with Mr. ? %s", name, check("Mr. Ann Bloggs", s -> s.startsWith("Mr.")));  // true
        name = "Ms. Ann Bloggs";

        System.out.printf("\nDoes %s start with Mr. ? %s", name, check("Mr. Ann Bloggs", s -> s.startsWith("Mr.")));  // false

    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
