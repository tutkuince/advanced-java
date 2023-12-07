package io.tince.advanced.java.lambda.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    // Consumer<T>      -> void accept(T t): use the parameter but not interested in the return value
    // BiConsumer<T, U> -> void accept(T t, U u)

    public static void main(String[] args) {
        // Consumer<T> is a functional interface i.e. one abstract method:
        // void accept(T t);
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question");
        System.out.println("--------------------------");

        List<String> nameList = new ArrayList<>();
        nameList.add("Tutku");
        nameList.add("Ciko");
        nameList.forEach(printC);
        System.out.println("--------------------------");

        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        // void accept(T t, U u)
        Map<String, String> mapCapitalCities = new HashMap<>();
        BiConsumer<String, String> biConsumer = (key, value) -> mapCapitalCities.put(key, value);
        biConsumer.accept("Dublin", "Ireland");
        biConsumer.accept("Washington D.C", "USA");
        biConsumer.accept("Ankara", "Turkey");
        System.out.println(mapCapitalCities);
        System.out.println("--------------------------");

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of " + value);
        mapCapitalCities.forEach((k, v) -> mapPrint.accept(k, v));
    }
}
