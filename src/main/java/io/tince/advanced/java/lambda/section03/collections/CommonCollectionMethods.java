package io.tince.advanced.java.lambda.section03.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CommonCollectionMethods {
    public static void main(String[] args) {
        Collection<String> stringCollection = new ArrayList<>();
        // asList() returns an unmodifiable collection
        // add(), remove() throws an UnsupportedOperationException
        //Collection<String> stringCollection = Arrays.asList("Lucy", "April", "Lucy"); // immutable

        stringCollection.add("Lucy");
        stringCollection.add("April");
        stringCollection.add("Lucy");

        System.out.println(stringCollection);                                   // [Lucy, April, Lucy]
        System.out.println(stringCollection.remove("Lucy"));                 // true
        System.out.println(stringCollection);                                   // [April, Lucy]
        System.out.println(stringCollection.isEmpty());                         // false
        System.out.println(stringCollection.size());                            // 2
        System.out.println(stringCollection.contains("John"));                  // false
        System.out.println(stringCollection.contains("Lucy"));                  // true
        // removeIf(Predicate) and Predicate == boolean test(T t)
        System.out.println(stringCollection.removeIf(s -> s.startsWith("A")));  // true
        stringCollection.forEach(name -> System.out.println(name));             // [Lucy]
        stringCollection.clear();
        stringCollection.forEach(System.out::println);                          // nothing output

    }
}
