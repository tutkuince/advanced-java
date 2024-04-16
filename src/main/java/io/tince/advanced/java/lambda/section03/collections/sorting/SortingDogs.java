package io.tince.advanced.java.lambda.section03.collections.sorting;

import io.tince.advanced.java.lambda.section03.collections.sorting.comparator.Dog;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {
    public static void main(String[] args) {
        comparable(new Dog[]{new Dog("Coco", 5), new Dog("Caju", 2)});
        comparable(Arrays.asList(new Dog("Coco", 5), new Dog("Caju", 2)));

        comparator(new Dog[]{new Dog("Coco", 5), new Dog("Caju", 2)});
        comparator(Arrays.asList(new Dog("Coco", 5), new Dog("Caju", 2)));
    }

    private static void comparator(Dog[] dogs) {
        // sorts ascending by age
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
        Arrays.sort(dogs, byAge);
        System.out.println(Arrays.toString(dogs));      // [Dog{name='Caju', age=2}, Dog{name='Coco', age=5}]

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Arrays.sort(dogs, byAgeReversed);
        System.out.println(Arrays.toString(dogs));      // [Dog{name='Coco', age=5}, Dog{name='Caju', age=2}]
    }

    private static void comparator(List<Dog> dogs) {
        // sorts ascending by age
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
        Collections.sort(dogs, byAge);
        System.out.println(dogs);   // [Dog{name='Caju', age=2}, Dog{name='Coco', age=5}]

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Collections.sort(dogs, byAgeReversed);
        System.out.println(dogs);   // [Dog{name='Coco', age=5}, Dog{name='Caju', age=2}]
    }

    private static void comparable(Dog[] dogs) {
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));  // [Dog{name='Caju', age=2}, Dog{name='Coco', age=5}]
    }

    private static void comparable(List<Dog> dogs) {
        Collections.sort(dogs);
        System.out.println(dogs);                   // [Dog{name='Caju', age=2}, Dog{name='Coco', age=5}]
    }
}
