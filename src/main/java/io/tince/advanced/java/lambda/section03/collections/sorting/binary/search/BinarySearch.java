package io.tince.advanced.java.lambda.section03.collections.sorting.binary.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        searchStrings();
        searchRabbits();
    }

    private static void searchRabbits() {
        Rabbit rabbit1 = new Rabbit("Fluffy", 1);
        Rabbit rabbit2 = new Rabbit("Coco", 3);
        List<Rabbit> rabbits = Arrays.asList(rabbit1, rabbit2);
        Collections.sort(rabbits);      // must sort first by natural order - name ascending
        System.out.println(rabbits);    // [Rabbit{name='Coco', age=3}, Rabbit{name='Fluffy', age=1}]
        /*
        * API: Searches the specified list for the specified object using the binary search algorithm.
        * The list must be sorted into ascending order according to the natural ordering of its elements (as by the sort(List) method) prior to making this call.
        * If it is not sorted, the results are undefined. If the list contains multiple elements equal to the specified object,
        * there is no guarantee which one will foundç
        * */
        System.out.println(Collections.binarySearch(rabbits, rabbit2)); // 0

        // set up the Comparator<T>
        // int compare(T o1, T o2)
        Comparator<Rabbit> byAge = (r1, r2) -> r1.getAge() - r2.getAge();
        Collections.sort(rabbits, byAge);
        System.out.println(rabbits);        // [Rabbit{name='Fluffy', age=1}, Rabbit{name='Coco', age=3}]
        System.out.println("Coco is at index: " + Collections.binarySearch(rabbits, rabbit2, byAge));   // Coco is at index: 1
    }

    private static void searchStrings() {
        List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
        Collections.sort(names);    // natural order sort - alphabetic for String
        System.out.println(names);  // [Ann, John, Martin, Paula]
        // if found, return index
        System.out.println(Collections.binarySearch(names, "John"));    // 1
        // if not found, return: -(indexItWouldHaveIfPresent) -1
        // "Laura" this is: -(2) -1 = -2 - 1 = -3
        System.out.println(Collections.binarySearch(names, "Laura"));
    }
}
