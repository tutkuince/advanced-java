package io.tince.advanced.java.section01.lambda.expressions;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperator {
    public static void main(String[] args) {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method: T apply(T t)
        // Transform the input into an output (types are the same)
        UnaryOperator<String> unaryOperator = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOperator.apply("Tutku"));   // My name is Tutku

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method: T apply(T t1, T t2)
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOperator.apply("William", "Shakespeare"));
    }
}
