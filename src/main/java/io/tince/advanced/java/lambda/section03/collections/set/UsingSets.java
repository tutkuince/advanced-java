package io.tince.advanced.java.lambda.section03.collections.set;

import io.tince.advanced.java.lambda.section03.collections.list.Contact;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsingSets {
    public static void main(String[] args) {
        // factoryMethods();
        treeSet();
        System.out.println("---------------");
        hashSet();
        System.out.println("---------------");
        linkedHashSet();
    }

    private static void linkedHashSet() {
        // API: This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries.
        // This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order)
        // This implementation spares its clients from the unspecified, generally chaotic ordering provided by HashSet, without incurring the
        // increased cost associated with TreeSet.

        // Hashing, insertion order
        Set<Contact> contactsLHS = new LinkedHashSet<>();
        contactsLHS.add(new Contact("Zoe", 45));
        contactsLHS.add(new Contact("Zoe", 45)); // ZOe only added once (Set)
        contactsLHS.add(new Contact("Alice", 34));
        contactsLHS.add(new Contact("Andrew", 23));
        contactsLHS.add(new Contact("Brian", 12));
        contactsLHS.add(new Contact("Carol", 65));
        for (Contact contact : contactsLHS) {
            System.out.println(contact);
        }

    }

    private static void hashSet() {
        // Order is completely random
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact("Zoe", 45));
        contactsHS.add(new Contact("Zoe", 45)); // Zoe only added once (Set)
        contactsHS.add(new Contact("Alice", 34));
        contactsHS.add(new Contact("Andrew", 35));
        contactsHS.add(new Contact("Brian", 15));
        contactsHS.add(new Contact("Carol", 37));
        for (Contact contact: contactsHS) {
            System.out.println(contact);
        }

    }

    private static void treeSet() {
        // SUU - Sets are Unique and Unordered
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");
        // No duplicates, elements are sorted alphabetically
        System.out.println(names);  // [Anne, Helen, John]

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);
        // No duplicates, elements are sorted numerically
        System.out.println(numbers);    // [11, 21, 23, 99]
    }

    private static void factoryMethods() {
        // unmodifiable sets returned
        Set<String> of = Set.of("a", "b", "c");
        Set<String> copy = Set.copyOf(of);

        of.add("d");        // UnsupportedOperationException
        copy.add("d");      // UnsupportedOperationException
        of.remove("a");  // UnsupportedOperationException
    }
}
