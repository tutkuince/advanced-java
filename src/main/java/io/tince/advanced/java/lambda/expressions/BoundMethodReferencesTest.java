package io.tince.advanced.java.lambda.expressions;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class BoundMethodReferencesTest {
    public static void main(String[] args) {
        String name = "Mr. William Defoe";
        Supplier<String> lowerL = () -> name.toLowerCase(); // lambda
        Supplier<String> lowerMR = name::toLowerCase;       // method reference

        // No need to say which instance to call it on - the supplier is bound to name
        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());
        System.out.println("------------------------");

        // Even though startsWith is overloaded, boolean startsWith(String) and
        // boolean startsWith(String, int), because we are creating a Predicate which
        // has a functional method of test(T t), the startsWith(String) is used.
        // This is where "context" is important
        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleL.test("Mr."));
        System.out.println(titleMR.test("Mr."));
    }
}
