package io.tince.advanced.java.lambda.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReferencesTest {
    public static void main(String[] args) {
        // Static method references are considered UNBOUND also. An example static method is Collections.sort(List)

        // Consumer takes one parameter => sort(List) is used, as opposed to sort (List, Comparator)
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
        sortL.accept(listOfNumbers);
        System.out.println(listOfNumbers);

        listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers);
        System.out.println(listOfNumbers);
    }
}
