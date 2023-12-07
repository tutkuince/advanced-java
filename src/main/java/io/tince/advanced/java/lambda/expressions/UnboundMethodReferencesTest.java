package io.tince.advanced.java.lambda.expressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UnboundMethodReferencesTest {
    public static void main(String[] args) {
        Function<String, String> upperL = s -> s.toLowerCase();
        Function<String, String> upperMR = String::toLowerCase;

        // The function is unbound, so you need to specify which instance to call it on
        System.out.println(upperL.apply("sean"));
        System.out.println(upperMR.apply("sean"));
        System.out.println("----------------");

        // First parameter is used for executing the instance method
        // "Sean ".concat("Kennedy")
        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatL.apply("Sean ", "Kennedy"));
        System.out.println(concatMR.apply("Sean ", "Kennedy"));
    }
}
