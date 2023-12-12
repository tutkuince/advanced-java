package io.tince.advanced.java.lambda.expressions.exercises;

import java.util.function.Supplier;

public class Exercise02 {

    /**
     * In main() invoke the supplier() method; in supplier() do the following:
     *
     * a) Using a lambda expression, implement the Retrievable interface (typed for Integer). The relevant method just returns 77. Invoke the relevant method.
     *
     * b) Using a lambda expression, implement 2a using a Supplier.
     * */
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
