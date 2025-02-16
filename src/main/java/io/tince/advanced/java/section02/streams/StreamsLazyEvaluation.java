package io.tince.advanced.java.section02.streams;

import java.util.stream.Stream;

public class StreamsLazyEvaluation {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(10, 11, 12, 13, 14);
    }
}
