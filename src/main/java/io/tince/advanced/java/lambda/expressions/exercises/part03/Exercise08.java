package io.tince.advanced.java.lambda.expressions.exercises.part03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Exercise08 {
    /**
     *Static method references:
     * a. in staticMR(), declare a List of integers with 1, 2, 7, 4, and 5 as values.
     * b. using a Consumer typed for List<Integer> and the Collections.sort static
     * method, code a lambda that sorts the list passed in.
     * c. invoke the lambda.
     * d. prove that the sort worked.
     * e. re-initialise the list (so it is unsorted again).
     * f. code the method reference version.
     *  i. sort() is overloaded : sort(List) and sort(List, Comparator)
     *  ii. how does Java know which version to call?
     * g. invoke the method reference version.
     * h. prove that the sort worked.
     * */
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println(integerList);
        Consumer<List<Integer>> consumer = Collections::sort;
        consumer.accept(integerList);
        System.out.println("After Sort Process");
        System.out.println(integerList);
    }
}
