package io.tince.advanced.java.section01.lambda.expressions;

import java.util.function.BiPredicate;

public class TestBiPredicate {
    public static void main(String[] args) {
        // BiPredicate<T, U> is a functional interface i.e. one abstract method: boolean test(T t, U u);
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8)); // false, length is 12
    }
}
