/*
Problem: Implement a Queue using Two Stacks

Approach:
- Use two stacks, s1 and s2, to implement FIFO behavior
- isEmpty(): Check whether s1 is empty
- add():
  - Move all elements from s1 to s2
  - Push the new element into s1
  - Move all elements back from s2 to s1
- remove(): Pop the top element from s1
- peek(): Return the top element of s1 without removing it

Complexity:
add(): Time O(n), Space O(n)
remove(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)

Key Idea:
- Stack follows LIFO, while Queue follows FIFO
- Moving elements between two stacks reverses their order
- s1 keeps the front element at the top, allowing O(1) remove and peek
*/
package Queues;

import java.util.*;

public class QueueUsingTwoStacks {

    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
