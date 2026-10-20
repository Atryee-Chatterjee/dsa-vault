/*
Problem: Implement a Stack using Two Queues

Approach:
- Use two queues, q1 and q2, to implement LIFO behavior
- isEmpty(): Check whether both queues are empty
- push(): Add the element to the non-empty queue, or q1 if both are empty
- pop(): Remove elements from the active queue and transfer them to the other queue until only the last element remains
- Return the last element removed as the top of the stack
- peek(): Transfer all elements to the other queue and return the last element without removing it from the stack

Complexity:
push(): Time O(1), Space O(1)
pop(): Time O(n), Space O(1) auxiliary
peek(): Time O(n), Space O(1) auxiliary
isEmpty(): Time O(1), Space O(1)

Key Idea:
- Queues follow FIFO, while stacks follow LIFO
- Transferring elements between queues allows the most recently added element to be removed first
- Only one queue holds elements between operations
*/
package Queues;
import java.util.*;

public class StackUsingTwoQueues {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            // Case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // Case 2
                if (!q2.isEmpty()) {
                    while (!q2.isEmpty()) {
                        top = q2.remove();
                        if (q2.isEmpty()) {
                            break;
                        }
                        q1.add(top);
                    }
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            // Case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // Case 2
                if (!q2.isEmpty()) {
                    while (!q2.isEmpty()) {
                        top = q2.remove();
                        q1.add(top);
                    }
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
