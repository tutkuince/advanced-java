package io.tince.advanced.java.section01.lambda.expressions;

// My own custom functional interface
@FunctionalInterface
interface Evaluate<T> {
    boolean isNegative(T t);
}

public class TestFunctionalInterface {
    public static void main(String[] args) {
        // Evaluate<T> is a functional interface i.e.
        // one abstract method: boolean isNegative(T t); --> similar to java.util.function.Predicate
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegative(-1));   // true
        System.out.println("Evaluate: " + lambda.isNegative(1));    // false
    }
}
