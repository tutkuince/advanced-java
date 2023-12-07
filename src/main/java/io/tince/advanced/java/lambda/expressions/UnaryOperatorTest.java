package io.tince.advanced.java.lambda.expressions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    // UnaryOperator<T>     -> T apply(T t): transform the input into an output (types are the same)
    // BinaryOperator<T>    -> T apply(T t1, T t2)
    public static void main(String[] args) {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method:
        // T apply(T t)
        UnaryOperator<String> unaryOperator = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOperator.apply("Tutku"));
        System.out.println("-----------------------------");

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        // T apply(T t1, T t2) => "Types must be same"
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOperator.apply("Mauro ", "Icardi"));
    }
}
