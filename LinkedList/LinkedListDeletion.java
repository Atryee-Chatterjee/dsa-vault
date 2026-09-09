/*
Problem: Delete the First and Last Element from a Singly Linked List

Approach:

- removeFirst():
  - Handle empty and single-node cases
  - Move head to the next node
  - Decrement size
- removeLast():
  - Handle empty and single-node cases
  - Traverse to the node before the tail
  - Remove the last node and update tail
  - Decrement size
- print(): Traverse from head and print all nodes

Complexity:

removeFirst(): Time O(1), Space O(1)
removeLast(): Time O(n), Space O(1)
print(): Time O(n), Space O(1)

Key Idea:

- Update head for deleting the first node
- Traverse to the previous node and update tail for deleting the last node
- Handle empty and single-node lists separately
*/
package LinkedList;

public class LinkedListDeletion {
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

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
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
        LinkedListDeletion ll = new LinkedListDeletion();
        ll.removeLast();
        ll.print();
    }

}
