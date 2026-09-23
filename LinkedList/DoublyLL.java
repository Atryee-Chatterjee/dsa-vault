/*
Problem: Implement a Doubly Linked List

Approach:
- Create a Node class with data, next, and prev references
- Maintain head, tail, and size of the linked list
- addFirst(): Insert a node at the beginning and update prev/next links
- addLast(): Insert a node at the end and update prev/next links
- removeFirst(): Remove the first node and update head
- removeLast(): Remove the last node and update tail
- print(): Traverse the list using next references

Complexity:
addFirst(): Time O(1), Space O(1)
addLast(): Time O(1), Space O(1)
removeFirst(): Time O(1), Space O(1)
removeLast(): Time O(1), Space O(1)
print(): Time O(n), Space O(1)

Key Idea:
- Each node stores references to both the next and previous nodes
- head points to the first node and tail points to the last node
- Updating both prev and next links maintains the doubly linked structure
*/
package LinkedList;

public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove first
    public int removeFirst() {
        if (head == null) {
            System.out.println("Empty DLL");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // Remove Last
    public int removeLast() {
        if (head == null) {
            System.out.println("Empty DLL");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        tail = tail.prev;
        tail.next = null;

        size--;
        return val;
    }

    // print
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();

        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);

        System.out.println("Original Doubly Linked List");
        ll.print();
        System.out.println("Current DLL size = " + ll.size);

        System.out.println("Remove from first");
        ll.removeFirst();
        ll.print();
        System.out.println("Current DLL size = " + ll.size);

        System.out.println("Remove from last");
        ll.removeLast();
        ll.print();
        System.out.println("Current DLL size = " + ll.size);
    }
}
