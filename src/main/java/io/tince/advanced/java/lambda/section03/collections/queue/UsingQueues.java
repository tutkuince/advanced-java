package io.tince.advanced.java.lambda.section03.collections.queue;

import java.util.*;

public class UsingQueues {
    public static void main(String[] args) {
        linkedListQueue();
        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    private static void priorityQueueDifferentOrdering() {
        // Ordering specified by a comparator at construction time
        // 1. Order by the title of the book
        // Comparator.comparing(Function)
        // API: "Accept a function that extracts a Comparable sort key from a type T, and returns a Comparator<T> that compares by that sort key."
        // Function<T, R>
        // R apply(T t)
        orderByBookTitle();
        orderByBookPrice();
    }

    private static void orderByBookTitle() {
        Comparator<Book> comparatorTitle = Comparator.comparing(Book::getTitle);
        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);   // Order by Title
        booksByTitle.add(new Book("Java", 55.00));
        booksByTitle.add(new Book("C++", 85.00));
        booksByTitle.add(new Book("Python", 25.00));
        System.out.println("\nOrdering Books by Title");
        Iterator<Book> bookIterator = booksByTitle.iterator();
        while (bookIterator.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);           // Book{title='Python', price=25.0} Book{title='Java', price=55.0} Book{title='C++', price=85.0}
        }
    }

    private static void orderByBookPrice() {
        Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
        Queue<Book> booksByPrice = new PriorityQueue<>(comparatorPrice);    // Order by Price
        booksByPrice.add(new Book("Java", 55.00));
        booksByPrice.add(new Book("C++", 85.00));
        booksByPrice.add(new Book("Python", 25.00));

        System.out.println("Ordering Books by Price");
        Iterator<Book> bookIterator = booksByPrice.iterator();
        while (bookIterator.hasNext()) {
            Book book = booksByPrice.poll();
            System.out.println(book);           //
        }
    }

    private static void priorityQueueNaturalOrdering() {
        // Natural Ordering
        Queue<String> names = new PriorityQueue<>();    // alphabetic ordering
        names.add("V");
        names.add("P");
        names.add("A");
        Iterator<String> iteratorNames = names.iterator();
        while (iteratorNames.hasNext()) {
            System.out.print(names.poll() + " "); // A P V
        }

        Queue<Integer> numbers = new PriorityQueue<>(); // numeric ordering
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);
        Iterator<Integer> iteratorNumbers = numbers.iterator();
        while (iteratorNumbers.hasNext()) {
            System.out.print(numbers.poll() + " "); // 2 5 11
        }
    }

    private static void linkedListQueue() {
        // A FIFO queue (First In First Out)
        Queue<Integer> queue = new LinkedList<>();
        // add - inserts into queue ( throws exception if no space exists - if capacity restricted)
        // offer - inserts into queue ( returns false if no space exists - capacity restricted)
        queue.add(1);          // Head -> [1]
        queue.offer(2);     // Head -> [1, 2]
        queue.add(3);          // Head -> [1, 2, 3]
        queue.offer(4);     // Head -> [1, 2, 3, 4]
        // element  - retrieves but does not remove the head of the queue (throws exception if queue empty)
        // peek     - retrieves but does not remove the head of the queue ( returns null if queue empty)
        System.out.println(queue.element());    // 1
        System.out.println(queue.peek());       // 1
        System.out.println(queue);              // [1, 2, 3, 4]
        // remove   - Retrieves and removes the head of this queue ( throws exception if queue empty )
        // poll     - Retrieves and removes the head of this queue ( returns null if this que is empty )
        System.out.println(queue.remove()); // 1    Head -> [2, 3, 4]
        System.out.println(queue.poll());   // 2    Head -> [3, 4]
        System.out.println(queue);          // [3, 4]

        // offer(), poll() and peek() are the preferred methods as they do not throw exceptions (P.O.P.)
    }
}
