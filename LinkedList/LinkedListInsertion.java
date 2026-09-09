/*
Problem: Insert an Element at a Given Index in a Singly Linked List

Approach:

- Create a new node with the given data
- If index is 0, insert the node using addFirst()
- Traverse to the node before the given index
- Update the links to insert the new node
- Increment size

Complexity:

add(index, data): Time O(n), Space O(1)
addFirst(): Time O(1), Space O(1)
print(): Time O(n), Space O(1)

Key Idea:

- Traverse to the previous node and adjust the next references
- Inserting at index 0 is handled separately using addFirst()
*/
package LinkedList;

public class LinkedListInsertion {
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

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

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

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LinkedListInsertion ll = new LinkedListInsertion();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();

        ll.add(1, 3);
        ll.print();

    }

}
