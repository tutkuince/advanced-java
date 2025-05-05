package io.tince.advanced.java.section01.lambda.expressions;

import java.time.LocalTime;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        // Supplier<T> --> when you want to supply values without any input.
        // is a functional interface i.e. one abstract method: T get()
        Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
        System.out.println("StringBuilder Supplier: " + stringBuilderSupplier.get().append("SK"));

        Supplier<LocalTime> localTimeSupplier = LocalTime::now;
        System.out.println("LocalTime Supplier: " + localTimeSupplier.get());

        Supplier<Double> doubleSupplier = Math::random;
        System.out.println("Random Supplier: " + doubleSupplier.get());
    }
}
