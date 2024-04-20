package io.tince.advanced.java.lambda.section03.collections.sorting.binary.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        searchStrings();
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
