package io.tince.advanced.java.lambda.expressions.exercises.part03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Exercise11 {
    /**
     * Constructor method references:
     * a. in constructorMR(), code a Supplier typed for List<String> that returns a new ArrayList.
     * b. invoke the lambda to create a new List<String> named list.
     * c. add “Lambda” to the list.
     * d. output the list to show it worked.
     * e. code the method reference version of the lambda:
     *  i. re-initialise list by invoking the method reference version.
     *  ii. add “Method Reference” to the list.
     *  iii. output the list to show it worked.
     * f. next, we want to use the overloaded ArrayList constructor passing in 10 as the initial capacity (note: the default constructor assumes a capacity of 10).
     *  i. thus, we need to pass IN something and get back OUT something:
     *      1. IN: 10 OUT: ArrayList
     *  ii. we need a Function typed for Integer and List<String> for this.
     *  iii. code the lambda.
     *  iv. re-initialise the list by invoking the lambda passing in 10 as the capacity.
     *  v. add “Lambda” to the list.
     *  vi. output the list to show it worked.
     * g. code the method reference version.
     *  i. note that the method reference version is the exact same as above in e!!
     *  ii. this is where context is all important:
     *      1. the first method reference was for a Supplier and Supplier’s functional method is T get() and thus, Java knew to look for the ArrayList constructor that takes in NO argument
     *      2. the first method reference was for a Function and Function’s functional method is R apply(T t) and thus, Java knew to look for the ArrayList constructor that takes in ONE argument.
     * */

    public static void main(String[] args) {
        Supplier<List<String>> supplier = ArrayList::new;
        List<String> list = supplier.get();
        list.add("Lambda");
        System.out.println(list);

        Function<Integer, List<String>> function = ArrayList::new;
        List<String> stringList = function.apply(20);
        System.out.println(stringList);
    }
}
