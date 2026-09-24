/*
Problem: Reverse a Doubly Linked List

Approach:
- Traverse the list using curr pointer
- Store the next node before changing the links
- Swap the next and prev references of each node
- Move curr to the original next node
- Update head to the last processed node

Complexity:
Time: O(n)
Space: O(1)

Key Idea:
- Reverse both next and prev references of every node
- The original tail becomes the new head
*/
package LinkedList;

public class ReverseDoublyLL {
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

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseDoublyLL dll = new ReverseDoublyLL();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        System.out.println("Original linked list");
        dll.print();

        System.out.println("Linked list after reverse");
        dll.reverse();
        dll.print();
    }
}
