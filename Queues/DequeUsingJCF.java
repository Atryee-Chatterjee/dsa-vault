/*
Problem: Implement a Deque using Java Collection Framework

Approach:
- Use the Deque interface to perform insertion and deletion at both ends
- Create a Deque using LinkedList
- addFirst(): Insert an element at the front
- addLast(): Insert an element at the rear
- removeFirst(): Remove and return the front element
- removeLast(): Remove and return the rear element
- peekFirst(): Return the front element without removing it
- peekLast(): Return the rear element without removing it

Complexity:
addFirst(): Time O(1)
addLast(): Time O(1)
removeFirst(): Time O(1)
removeLast(): Time O(1)
peekFirst(): Time O(1)
peekLast(): Time O(1)

Key Idea:
- A Deque (Double-Ended Queue) allows insertion and deletion at both ends
- LinkedList implements the Deque interface
- A deque can be used as both a queue (FIFO) and a stack (LIFO)
*/
package Queues;

import java.util.*;

public class DequeUsingJCF {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        // Add elements to the front of the deque
        deque.addFirst(1);
        deque.addFirst(2);

        // Add elements to the rear of the deque
        deque.addLast(3);
        deque.addLast(4);

        System.out.println("Deque elements: " + deque);

        // Remove elements from the front of the deque
        System.out.println("Removed from front: " + deque.removeFirst());

        // Remove elements from the rear of the deque
        System.out.println("Removed from rear: " + deque.removeLast());

        // Peek at the front and rear elements
        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Rear element: " + deque.peekLast());
    }
}
