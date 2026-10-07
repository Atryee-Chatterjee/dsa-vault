/*
Problem: Implement a Queue using a Linked List

Approach:
- Create a Node class to store data and the next reference
- Maintain head as the front and tail as the rear of the queue
- isEmpty(): Check whether both head and tail are null
- add(): Insert a new node at the tail
- remove(): Remove and return the node from the head
- peek(): Return the front element without removing it
- Update head and tail when the queue becomes empty

Complexity:
add(): Time O(1), Space O(1)
remove(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)

Key Idea:
- Queue follows FIFO (First In, First Out)
- Elements are added at the tail and removed from the head
- Using head and tail pointers makes insertion and deletion O(1)
*/
package Queues;

public class QueuesUsingLL {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
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
