package io.tince.advanced.java.section01.lambda.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestConsumerAndBiConsumer {
    public static void main(String[] args) {
        // Consumer<T> is a functional interface i.e. one abstract method: void accept();
        // Consumer<T> --> use the parameter but not interested in the return value.
        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printConsumer);

        // BiConsumer<T, U> is a functional interface i.e. one abstract method: void accept(T t, U u)
        Map<String, String> mapCapitalCities = new HashMap<>();
        BiConsumer<String, String> biConsumer = mapCapitalCities::put;
        biConsumer.accept("Ankara", "Türkiye");
        biConsumer.accept("Berlin", "Germany");
        System.out.println(mapCapitalCities);   // {Berlin=Germany, Ankara=Türkiye}

        BiConsumer<String, String> printMap = (key, value) -> System.out.println(key + " is the capital of " + value);
        mapCapitalCities.forEach(printMap);
    }
}
