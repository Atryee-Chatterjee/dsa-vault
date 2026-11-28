/*
Problem: Rearrange Linked List into Even and Odd Nodes

Approach:
- Create separate dummy nodes for even and odd elements
- Maintain tail pointers for both even and odd lists
- Traverse the original linked list using a current pointer
- If the current node contains an even value, add it to the even list
- Otherwise, add it to the odd list
- Connect the even list to the odd list
- Set the last odd node's next pointer to null
- Update the head to point to the beginning of the rearranged list

Complexity:
Time: O(n)
Space: O(1)
Here, n is the number of nodes in the linked list.
Only a fixed number of extra pointers and dummy nodes are used.

Key Idea:
- Separate even and odd nodes while preserving their original relative order
- Connect all even nodes before the odd nodes
- Rearrange the linked list by updating next pointers without creating new data nodes
*/
package LinkedList;

public class OddEvenLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    // Rearrange even and odd nodes
    public void rearrange() {

        Node evenHead = new Node(0);
        Node oddHead = new Node(0);

        Node evenTail = evenHead;
        Node oddTail = oddHead;

        Node curr = head;

        while (curr != null) {

            if (curr.data % 2 == 0) {
                evenTail.next = curr;
                evenTail = evenTail.next;
            } else {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }

            curr = curr.next;
        }

        // Connect even nodes with odd nodes
        evenTail.next = oddHead.next;
        oddTail.next = null;

        head = evenHead.next;
    }

    // Insert a node at the end
    public void add(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Print the linked list
    public void printList() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        OddEvenLinkedList list = new OddEvenLinkedList();

        list.add(8);
        list.add(12);
        list.add(10);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(6);

        System.out.println("Original Linked List:");
        list.printList();

        list.rearrange();

        System.out.println("Modified Linked List:");
        list.printList();
    }
}
