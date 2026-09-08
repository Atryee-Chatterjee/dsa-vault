/*
Problem: Implement a Singly Linked List

Approach:
- Create a Node class to store data and a reference to the next node
- Maintain two pointers: head and tail
- addFirst():
  - Create a new node
  - If the list is empty, make the new node both head and tail
  - Otherwise, connect the new node to the current head
  - Update head to the new node
- addLast():
  - Create a new node
  - If the list is empty, make the new node both head and tail
  - Otherwise, connect the new node after the current tail
  - Update tail to the new node
- print():
  - Start from head and traverse the list using the next reference
  - Print each node's data until reaching null

Complexity:
addFirst(): Time O(1), Space O(1)
addLast(): Time O(1), Space O(1)
print(): Time O(n), Space O(1)

Key Idea:
- head points to the first node
- tail points to the last node
- Each node stores data and a reference to the next node
- Using both head and tail makes insertion at both ends efficient
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

    public void addFirst(int data) {
        // Step1 = create new node
        Node newNode = new Node(data);
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
        
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addFirst(10);
        ll.print();
    }
}
