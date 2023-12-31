package io.tince.advanced.java.lambda.expressions.exercises.part01;

import java.util.function.Consumer;

public class Exercise01 {

    // Using a lambda expression, implement the Printable interface (typed for String).
    // a) The relevant method just prints out the String argument it receives. Invoke the relevant method, passing in "Printable lambda".
    // b) Using both a lambda expression and a method reference, implement 1a using a Consumer.

    public static void main(String[] args) {
        Printable<String> printable1 = s -> System.out.println(s);
        printable1.print("Printable lambda");

        Consumer<String> stringConsumer = s -> System.out.println(s);
        stringConsumer.accept("Consumer lambda");

        Consumer<String> stringConsumerMR = System.out::println;
        stringConsumerMR.accept("Consumer method reference");
    }
}

interface Printable<T> {
    void print(T t);
}
