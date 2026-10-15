/*
Problem: Reverse the First K Elements of a Queue

Approach:
- Check whether k is valid
- Remove the first k elements from the queue and push them onto a stack
- Pop the elements from the stack and add them back to the queue
- Move the remaining elements to the back to maintain their original order

Complexity:
Time: O(n)
Space: O(k)

Key Idea:
- The stack reverses the order of the first k elements using LIFO
- The queue maintains the original order of the remaining elements using FIFO
*/
package Queues;

import java.util.*;

public class ReverseFirstKElements {

    public static void reverseFirstK(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size()) {
            return;
        }

        Stack<Integer> s = new Stack<>();

        // Push the first k elements onto the stack
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        // Add them back in reverse order
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // Move the remaining elements to the back
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        int k = 3;

        reverseFirstK(q, k);

        System.out.println(q);
    }
}
