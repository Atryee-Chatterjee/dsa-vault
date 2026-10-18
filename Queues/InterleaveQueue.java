/*
Problem: Interleave the First and Second Halves of a Queue

Approach:
- Check whether the queue size is even
- Create a separate queue to store the first half of the elements
- Remove the first half of the elements from the original queue and add them to firstHalf
- Alternately add one element from firstHalf and one from the original queue
- Continue until all elements are interleaved

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- Store the first half separately to preserve its order
- Alternately combine elements from both halves
- Example: [1, 2, 3, 4, 5, 6] becomes [1, 4, 2, 5, 3, 6]
*/
package Queues;

import java.util.*;

public class InterleaveQueue {

    public static void interleave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even");
            return;
        }

        Queue<Integer> firstHalf = new LinkedList<>();

        int half = q.size() / 2;

        // Store the first half
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.remove());
        }

        // Interleave both halves
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= 6; i++) {
            q.add(i);
        }

        interleave(q);

        System.out.println(q);
    }
}
