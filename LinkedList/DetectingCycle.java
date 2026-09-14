/*
Problem: Detect a Cycle in a Singly Linked List

Approach:
- Use Floyd's Cycle Detection Algorithm
- Maintain two pointers: slow and fast
- Move slow by one node and fast by two nodes
- If slow and fast meet, a cycle exists
- If fast reaches null, no cycle exists

Complexity:
Time: O(n)
Space: O(1)

Key Idea:
- The fast pointer moves twice as fast as the slow pointer
- If a cycle exists, both pointers will eventually meet
*/
package LinkedList;

public class DetectingCycle {
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

    public static boolean isCycle() { // Floyd's Cycle Detection Algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true; // Cycle exists
            }
        }
        return false; // Cycle doesn't exists
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // Create a cycle
        //1->2->3->2 (cycle)

        System.out.println(isCycle());
    }
}