/*
Problem: Delete N Nodes After Skipping M Nodes in a Linked List

Approach:
- Traverse the linked list using a current pointer
- Skip the first M nodes
- Store the next node after the M skipped nodes
- Move a temporary pointer ahead by N nodes to delete them
- Connect the current node to the remaining list
- Continue the process until the end of the list

Complexity:
Time: O(n)
Space: O(1)
Here, n is the total number of nodes in the linked list.

Key Idea:
- Skip M nodes and delete the next N nodes repeatedly
- Update the next pointer to remove nodes without changing their values
- Modify the linked list in-place without using extra data structures
*/
package LinkedList;

public class DeleteNNodesAfterMNodes {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head;

        while (curr != null) {

            // Skip M nodes
            for (int count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            // Delete next N nodes
            Node temp = curr.next;

            for (int count = 1; count <= N && temp != null; count++) {
                temp = temp.next;
            }

            // Connect remaining nodes
            curr.next = temp;
            curr = temp;
        }
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int M = 2;
        int N = 2;

        System.out.println("Original Linked List:");
        printList(head);

        skipMdeleteN(head, M, N);

        System.out.println("Linked List after deletion:");
        printList(head);
    }
}
