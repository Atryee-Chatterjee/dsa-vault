/*
Problem: Implement a Stack using a Linked List

Approach:
- Create a Node class to store data and the next reference
- Use head as the top of the stack
- isEmpty(): Check whether the stack is empty
- push(): Add a new node at the beginning
- pop(): Remove and return the top node
- peek(): Return the top element without removing it

Complexity:
push(): Time O(1), Space O(1)
pop(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)

Key Idea:
- The head node represents the top of the stack
- Insertion and deletion at the beginning allow all stack operations to be performed in O(1)
- The stack follows LIFO (Last In, First Out)
*/
package Stacks;
import java.util.ArrayList;

public class StackUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        // isEmpty
        public static boolean isEmpty() {
            return head == null;
        }

        // Push
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // Pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
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
