package io.tince.advanced.java.section01.lambda.expressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("John");

        int x = 12; // final or effectively final

        // Lambdas take a snapshot/picture of local variables; these local variables MUST NOT change. Ony setting up lambda here.
        Predicate<String> lambda = s -> {
            // x++ --> local variables referenced from a lambda expression must be final or effectively final
            // cant change it inside the lambda
            new LambdaEffectivelyFinal().name = "Kennedy";  // instance/class vars are ok
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };
        filterData(list, lambda);
        System.out.println(list);

        new LambdaEffectivelyFinal().name = "Sean"; // instance/class vars are OK.

        // If 'x' was allowed to change, then the method and the lambda would have 2 different views of 'x'!
        // x++;
        filterData(list, lambda);   // lambda views 'x' as 12
    }

    public static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (lambda.test(iterator.next())) { // executing lambda here
                iterator.remove();
            }
        }
    }
}
