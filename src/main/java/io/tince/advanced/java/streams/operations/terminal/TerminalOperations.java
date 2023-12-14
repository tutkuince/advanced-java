package io.tince.advanced.java.streams.operations.terminal;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {

    }

    public static void doCollect1() {
        // StringBuilder collect(Supplier<StringBuilder> supplier,
        //               BiConsumer<StringBuilder,String> accumulator
        //               BiConsumer<StringBuilder,StringBuilder> combiner)
        // This version is used when you want complete control over
        // how collecting should work. The accumulator adds an element
        // to the collection e.g. the next String to the StringBuilder.
        // The combiner takes two collections and merges them. It is useful
        // in parallel processing.
        StringBuilder word = Stream.of("ad"," jud", "i", "cate")
                .collect(() -> new StringBuilder(),
                        (stringBuilder, s) -> stringBuilder.append(s),
                        (stringBuilder, stringBuilder2) -> stringBuilder.append(stringBuilder2));
        System.out.println(word);
    }

    public static void doReduce2(){

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        // When you leave out the indentity, an Optional is
        // returned because there may not be any data (all the
        // elements could have been filtered out earlier). There are
        // 3 possible results:
        //      a) empty stream => empty Optional returned
        //      b) one element in stream => that element is returned
        //      c) multiple elements in stream => accumulator is applied
        BinaryOperator<Integer> op = (a, b) -> a+b;
        Stream<Integer> empty               = Stream.empty();
        Stream<Integer> oneElement          = Stream.of(6);
        Stream<Integer> multipleElements    = Stream.of(3, 4, 5);
        empty.reduce(op).ifPresent(System.out::println);            //
        oneElement.reduce(op).ifPresent(System.out::println);       // 6
        multipleElements.reduce(op).ifPresent(System.out::println); // 12
        // Why not just require the identity and remove this method?
        // Sometimes it is nice to know if the stream is empty as opposed
        // to the case where there is a value returned from the accumulator
        // that happens to match the identity (however unlikely).
        Integer val = Stream.of(1,1,1)
                //     .filter(n -> n > 5)      // val is 1 this way
                .reduce(1, (a, b) -> a );// val is 1 this way too
        System.out.println(val);// 1
    }
    public static void doReduce3(){

        // <U> U reduce (U identity,
        //               BiFunction accumulator,
        //               BinaryOperator combiner)
        // We use this version when we are dealing with different types,
        // allowing us to create intermediate reductions and then combine
        // them at the end. This is useful when working with parallel
        // streams - the streams can be decomposed and reassembled by
        // separate threads. For example, if we wanted to count the length
        // of four 1000-character strings, the first 2 values and the last
        // two values could be calculated independently. The intermediate
        // results (2000) would then be combined into a final value (4000).
        // Example: we want to count the number of characters in each String
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce( 0,  // identity
                (n, str) -> n + str.length(), // n is Integer
                (n1, n2) -> n1 + n2); // both are Integers
        System.out.println(length);// 20
    }

}
