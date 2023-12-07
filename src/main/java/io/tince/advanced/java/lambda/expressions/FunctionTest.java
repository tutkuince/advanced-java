package io.tince.advanced.java.lambda.expressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    // Function<T, R>       -> R apply(T t): transform the input into an output (types can be different)
    // BiFunction<T, U, R>  -> R apply(T t, U u)
    public static void main(String[] args) {
        // Function<T, R> is a functional interface i.e. one abstract method:
        // R apply(T t)
        Function<String, Integer> functionStringLength = s -> s.length();
        System.out.println(functionStringLength.apply("Mauro Emanuel Icardi"));
        System.out.println("--------------------------------------");
        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        // R apply(T t, U u)
        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();
        System.out.println(biFunction.apply("Mauro", "Icardi"));
        System.out.println("--------------------------------------");

        BiFunction<String, String, String> biFunctionConcat = (s1, s2) -> s1.concat(s2);
        System.out.println(biFunctionConcat.apply("Mauro ", "Icardi"));
    }
}
