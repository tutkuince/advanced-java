package io.tince.advanced.java.streams;

import java.util.Arrays;
import java.util.List;

public class Laziness {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Brooke", "Christian");

        names.stream()
                .peek(System.out::println)
                .filter(name -> {
                    System.out.println("filter-1: " + name);
                    return name.startsWith("B") || name.startsWith("C");
                })
                .filter(name -> {
                    System.out.println("filter-2: " + name);
                    return name.length() > 3;
                })
                .limit(1)               // intermediate operation Stream<T> limit(long)
                .forEach(System.out::println);  // terminal operation
    }
}
