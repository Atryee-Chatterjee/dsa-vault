/*
Problem: Implement a Circular Queue using an Array

Approach:
- Use an array with front and rear pointers
- isEmpty(): Check if both front and rear are -1
- isFull(): Check if the next rear position is equal to front
- add(): Insert an element at the rear using circular indexing
- remove(): Remove the front element and move front circularly
- peek(): Return the front element without removing it
- Reset front and rear when the last element is removed

Complexity:
add(): Time O(1), Space O(1)
remove(): Time O(1), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)
isFull(): Time O(1), Space O(1)

Key Idea:
- Use modulo (%) to move front and rear circularly
- Reuse empty spaces created after removing elements
- Queue follows FIFO (First In, First Out)
*/
package Queues;

public class CircularQueueUsingArrays {
    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            // last element delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}