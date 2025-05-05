package io.tince.advanced.java.section01.lambda.expressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunction {
    public static void main(String[] args) {
        // Function<T, R> is a functional interface i.e. one abstract method: R apply(T t)
        // Transform the input into an output (types can be different)
        Function<String, Integer> function = String::length;
        System.out.println("Function: " + function.apply("Moscow"));    // 6

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method R apply(T t, U u)
        BiFunction<String, String, Integer> biFunctionSum = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFunctionSum.apply("William", "Shakespeare"));    // 18

        BiFunction<String, String, String> biFunctionConcat = String::concat;
        System.out.println("BiFunction: " + biFunctionConcat.apply("William ", "Shakespeare"));    // William Shakespeare
    }
}
