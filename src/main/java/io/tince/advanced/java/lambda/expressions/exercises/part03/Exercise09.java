package io.tince.advanced.java.lambda.expressions.exercises.part03;

import java.util.function.Predicate;

public class Exercise09 {
    /**
     * Bound method references (calling instance methods on a particular object):
     * a. in boundMR(), declare a String variable called name and initialise it to “Mr. Joe Bloggs”.
     * b. using a Predicate typed for String, code a lambda that checks to see if name starts with the prefix passed in.
     * c. invoke the lambda passing in “Mr.” which should return true.
     * d. invoke the lambda passing in “Ms.” which should return false.
     * e. code the method reference version.
     * f. repeat c and d above except using the method reference version.
     * */
    public static void main(String[] args) {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate = name::startsWith;
        System.out.println(name + "start with Mr.? => " + predicate.test("Mr."));
        System.out.println(name + "start with Mr.? => " + predicate.test("Ms."));
    }
}
