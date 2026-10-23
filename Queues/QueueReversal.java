/*
Problem: Reverse a Queue

Approach:
- Use a stack to reverse the order of queue elements
- Remove each element from the queue and push it onto the stack
- Pop elements from the stack and add them back to the queue
- The queue now contains the elements in reverse order

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The queue follows FIFO, while the stack follows LIFO
- Using a stack reverses the order of the elements
*/
package Queues;

import java.util.*;

public class QueueReversal {
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < 6; i++) {
            q.add(i);
        }

        queueReversal(q);
        System.out.println(q);
    }
}
