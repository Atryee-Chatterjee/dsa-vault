/*
Problem: Implement a Queue using an Array

Approach:
- Use an array to store queue elements
- Maintain rear to track the last inserted element
- isEmpty(): Check whether the queue is empty
- add(): Insert an element at the rear
- remove(): Remove the front element and shift remaining elements
- peek(): Return the front element without removing it
- Check for overflow when the queue is full

Complexity:
add(): Time O(1), Space O(1)
remove(): Time O(n), Space O(1)
peek(): Time O(1), Space O(1)
isEmpty(): Time O(1), Space O(1)

Key Idea:
- Queue follows FIFO (First In, First Out)
- Elements are added from the rear and removed from the front
- Since this implementation uses a simple array, removing an element requires shifting the remaining elements
*/
package Queues;

class QueuesUsingArrays {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return ;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        public static int remove(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}