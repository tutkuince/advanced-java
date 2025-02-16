package io.tince.advanced.java.section02.streams;

import java.util.stream.Stream;

public class StreamsLazyEvaluation {

    public static void main(String[] args) {
        // Lazy Evaluation
        Stream<Integer> integerStream = Stream.of(10, 11, 12, 13, 14);

        Stream<Integer> filteredIntegerStream = integerStream.filter(i -> {
            System.out.println("Filtering integer");
            return i % 2 == 0;
        });

        System.out.println("Count is: " + filteredIntegerStream.count());
    }
}
