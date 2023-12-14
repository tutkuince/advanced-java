package io.tince.advanced.java.streams.operations.terminal;

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
}
