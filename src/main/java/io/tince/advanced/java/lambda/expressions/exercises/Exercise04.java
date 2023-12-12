package io.tince.advanced.java.lambda.expressions.exercises;

import java.util.function.Function;

public class Exercise04 {
    /**
     * In main() invoke the function() method; in function() do the following:
     *
     * a) Using a lambda expression, implement the Functionable interface - the input type is Integer and the return type is String.
     * The relevant method returns the number passed in appended to the String “Number is: ”. Invoke the relevant method passing in 25.
     *
     * b) Using a lambda expression, implement 4a using a Function.
     *
     * */
    public static void main(String[] args) {
        Functionable<Integer, String> functionable = s -> {
            return "Number is: " + s;
        };
        System.out.println("Functionable: " + functionable.applyThis(25));

        Function<Integer, String> integerFunction = s -> "Number is: " + s;
        System.out.println("Function: " + integerFunction.apply(25));
    }
}

interface Functionable<T, R> {
    R applyThis(T t);
}
