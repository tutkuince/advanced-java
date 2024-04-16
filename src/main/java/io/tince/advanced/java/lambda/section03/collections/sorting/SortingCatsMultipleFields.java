package io.tince.advanced.java.lambda.section03.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCatsMultipleFields {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Coco", 6));
        cats.add(new Cat("Cashew", 2));
        cats.add(new Cat("Kamus", 5));
        cats.add(new Cat("Fero", 1));
        Comparator<Cat> comparator = Comparator.comparing(Cat::getName).thenComparing(Cat::getAge);
        Collections.sort(cats, comparator);
        System.out.println(cats);
    }
}
