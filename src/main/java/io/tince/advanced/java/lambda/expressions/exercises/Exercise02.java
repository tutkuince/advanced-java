package io.tince.advanced.java.lambda.expressions.exercises;

import java.util.function.Supplier;

public class Exercise02 {
    public static void main(String[] args) {
        Retrievable<Integer> retrievable = () -> {return 77;};
        System.out.println("Retrievable: " + retrievable.retrieve());

        Supplier<Integer> integerSupplier = () -> 77;
        System.out.println("Supplier: " + integerSupplier.get());
    }
}
interface Retrievable<T> {
    T retrieve();
}
