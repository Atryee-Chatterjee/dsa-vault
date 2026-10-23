/*
Problem: Implement a Stack using a Deque

Approach:
- Use a Deque to implement stack operations
- push(): Insert an element at the rear using addLast()
- pop(): Remove and return the top element using removeLast()
- peek(): Return the top element using getLast() without removing it

Complexity:
push(): Time O(1), Space O(1)
pop(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)

Key Idea:
- Stack follows LIFO (Last In, First Out)
- Insert and remove elements from the same end of the deque
- A Deque supports operations at both ends, making it suitable for implementing a stack
*/
package Queues;

import java.util.*;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek = " + s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
