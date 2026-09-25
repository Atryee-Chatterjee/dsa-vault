/*
Problem: Implement a Stack using an ArrayList

Approach:
- Use an ArrayList to store stack elements
- Treat the last element of the ArrayList as the top of the stack
- isEmpty(): Check whether the ArrayList is empty
- push(): Add an element at the end of the ArrayList
- pop(): Remove and return the last element
- peek(): Return the last element without removing it

Complexity:
push(): Time O(1), Space O(1)
pop(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)

Key Idea:
- The last element of the ArrayList represents the top of the stack
- Adding and removing elements from the end follows LIFO (Last In, First Out)
*/
package Stacks;
import java.util.ArrayList;

public class StackUsingArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // isEmpty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // Push
        public static void push(int data) {
            list.add(data);
        }

        // Pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            return val;
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
