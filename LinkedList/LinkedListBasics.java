/*
Problem: Implement a Singly Linked List

Approach:

- Create a Node class with data and next reference
- Maintain head, tail, and size
- addFirst(): Insert a node at the beginning and update head
- addLast(): Insert a node at the end and update tail
- print(): Traverse from head and print all nodes

Complexity:

addFirst(): Time O(1), Space O(1)
addLast(): Time O(1), Space O(1)
print(): Time O(n), Space O(1)

Key Idea:

- head points to the first node
- tail points to the last node
- size tracks the number of nodes
*/
package LinkedList;

public class LinkedListBasics {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // Step1 = create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Step2 = newNode next = head
        newNode.next = head; // Link

        // step3 = head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListBasics ll = new LinkedListBasics();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addFirst(10);
        ll.print();
        System.out.println(size);

    }
}
