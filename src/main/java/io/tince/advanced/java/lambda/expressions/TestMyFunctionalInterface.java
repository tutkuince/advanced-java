package io.tince.advanced.java.lambda.expressions;

// my own custom functional interface
interface Evaluate<T> {
    boolean isNegative(T t);    // similar to Predicate
}

public class TestMyFunctionalInterface {
    public static void main(String[] args) {
        // Evaluate<T> is a functional interface i.e. one abstract method:
        // boolean isNegative(T t); -> similar to java.util.function.Predicate
        Evaluate<Integer> lambda = i -> i < 0;
//        Evaluate<Integer> lambda = i -> {return i < 0;};
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(+1));
    }
}
