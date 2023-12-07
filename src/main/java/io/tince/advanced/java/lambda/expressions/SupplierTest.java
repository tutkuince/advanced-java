package io.tince.advanced.java.lambda.expressions;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierTest {
    // Supplier<T> -> T get(): when you want to supply values without any input

    public static void main(String[] args) {
        // Supplier<T> is a functional interface i.e. one abstract method:
        // T get()
        Supplier<StringBuilder> stringBuilderSupplier = () -> new StringBuilder();
        System.out.println("Supplier SB: " + stringBuilderSupplier.get().append("SK"));
        System.out.println("--------------------------");

        Supplier<LocalTime> localTimeSupplier = () -> LocalTime.now();
        System.out.println("Supplier time: " + localTimeSupplier.get());
        System.out.println("--------------------------");

        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println("Supplier Random Double: " + doubleSupplier.get());
    }
}
