package io.tince.advanced.java.lambda.section03.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class UsingQueues {
    public static void main(String[] args) {
        linkedListQueue();
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
