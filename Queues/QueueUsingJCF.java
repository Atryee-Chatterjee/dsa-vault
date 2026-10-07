/*
Problem: Implement a Queue using Java Collection Framework

Approach:
- Use the Queue interface to create a FIFO (First In, First Out) queue
- ArrayDeque and LinkedList both implement the Queue interface
- add(): Insert elements at the rear of the queue
- peek(): View the front element without removing it
- remove(): Remove the front element from the queue

Why ArrayDeque and LinkedList?

- ArrayDeque:
  - Uses a resizable array internally
  - Faster and more memory-efficient for most queue operations
  - Recommended when a simple queue is needed
  - Does not allow null elements

- LinkedList:
  - Uses a doubly linked list internally
  - Supports Queue and Deque operations
  - Uses extra memory for node references
  - Useful when linked-list behavior is also required

Complexity:
add(): O(1) amortized
remove(): O(1)
peek(): O(1)

Key Idea:
- Queue provides a standard interface for FIFO operations
- ArrayDeque is generally preferred for queue implementation
- LinkedList can also be used when linked-list functionality is needed
*/
package Queues;

import java.util.*;

public class QueueUsingJCF {

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}