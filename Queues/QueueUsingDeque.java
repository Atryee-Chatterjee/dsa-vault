/*
Problem: Implement a Queue using a Deque

Approach:
- Use a Deque to implement queue operations
- add(): Insert an element at the rear using addLast()
- remove(): Remove and return the front element using removeFirst()
- peek(): Return the front element using getFirst()

Complexity:
add(): Time O(1), Space O(1)
remove(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)

Key Idea:
- Queue follows FIFO (First In, First Out)
- Insert elements at the rear and remove them from the front
- A Deque supports operations at both ends, making it suitable for implementing a queue
*/
package Queues;

import java.util.*;

public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Peek = " + q.peek());

        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
