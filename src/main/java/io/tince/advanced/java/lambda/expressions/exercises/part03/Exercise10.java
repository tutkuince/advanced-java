package io.tince.advanced.java.lambda.expressions.exercises.part03;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Exercise10 {
    /**
     * Unbound method references (calling instance methods on a parameter):
     * a. in unboundMR(), code a Predicate lambda typed for String that checks to see if the string passed in is empty.
     * b. invoke the lambda passing in “” (returns true).
     * c. invoke the lambda passing in “xyz” (returns false).
     * d. code the method reference version of the lambda from (a).
     * e. repeat b and c above except using the method reference version.
     * f. code a BiPredicate lambda typed for String and String:
     *  i. the lambda takes in two parameters (hence “Bi”)
     *  ii. check if the first parameter starts with the second parameter
     *  iii. invoke the lambda twice:
     * 1. passing in “Mr. Joe Bloggs” and “Mr.” (returns true)
     * 2. passing in “Mr. Joe Bloggs” and “Ms.” (returns false)
     * g. code the method reference version of the lambda from (f).
     * h. test it as per above in (f.iii)
     * */
    public static void main(String[] args) {
        Predicate<String> predicate = String::isEmpty;
        System.out.println("Parameter is null: " + predicate.test(""));
        System.out.println("Parameter is null: " + predicate.test("xyz"));

        BiPredicate<String, String> biPredicate = String::startsWith;
        System.out.println("First parameter starts with the second parameter: " + biPredicate.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("First parameter starts with the second parameter: " + biPredicate.test("Mr. Joe Bloggs", "Ms."));

    }
}
