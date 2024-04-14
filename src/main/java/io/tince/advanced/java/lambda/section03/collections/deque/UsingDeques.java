package io.tince.advanced.java.lambda.section03.collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingDeques {
    public static void main(String[] args) {
        arrayDeque();
    }

    private static void arrayDeque() {
        // Deque: "Doubly ended queue". Supports element insertion/removal at both ends.
        // ArrayDeque: resizeable-array implementation of te Deque interface ( no capacity restrictions )
        Deque<Integer> numbers = new ArrayDeque<>();
        // Deque methods that begin with "a", "r" or "g" e.g. addFirst(), addLast(),
        // removeFirst(), removeLast(), getFirst() and getLast() all throw exceptions if the deque is both capacity-constrained and full
        // The other methods (POP): peekFirst(), peekLast(), offerFirst(), offerLast(), pollFirst(), pollLast;
        // rather than throw an exception in the same situation, they return null/false.
        // add at front ( the head )
        numbers.add(1);             // Head -> [1] <- Tail
        numbers.addFirst(2);     // Head -> [2, 1] <- Tail
        numbers.offerFirst(3);   // Head -> [3, 2, 1] <- Tail
        System.out.println("Head: " + numbers.getFirst() + ". Head: " + numbers.peekFirst());   // Head: 3. Head: 3
        // add at end (the tail)
        numbers.addLast(4);     // Head -> [3, 2, 1, 4, 5] <- Tail
        numbers.addLast(5);
        // remove from both ends
        numbers.removeFirst();      // Head -> [2, 1, 4, 5] <- Tail
        numbers.pollFirst();        // Head -> [1, 4, 5] <- Tail
        numbers.removeLast();       // Head -> [1, 4] <- Tail
        numbers.pollLast();         // Head -> [1] <- Tail
        System.out.println(numbers);    // [1]

    }
}
