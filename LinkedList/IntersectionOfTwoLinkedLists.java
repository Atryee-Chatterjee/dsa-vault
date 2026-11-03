/*
Problem: Find the Intersection Point of Two Linked Lists

Approach:
- Traverse the second linked list node by node
- For each node, traverse the first linked list
- Compare node references using ==
- If both references point to the same node, return that node
- If no matching node is found, return null

Complexity:
Time: O(n * m)
Space: O(1)
Here, n and m are the lengths of the two linked lists.

Key Idea:
- Intersection is based on node references, not node values
- Two linked lists intersect when they share the same node in memory
- Compare nodes using == instead of comparing their data
*/
package LinkedList;

public class IntersectionOfTwoLinkedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersectionNode(Node head1, Node head2) {

        // Traverse the second linked list
        while (head2 != null) {
            Node temp = head1;

            // Check each node of the first linked list
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }

                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {

        // Create first linked list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        // Create second linked list: 3 -> 6 -> 9
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        // Connect both lists at the same node (15)
        head2.next.next.next = head1.next;

        Node intersectionPoint = getIntersectionNode(head1, head2);

        if (intersectionPoint == null) {
            System.out.println("No Intersection Point");
        } else {
            System.out.println("Intersection Point: " + intersectionPoint.data);
        }
    }
}
