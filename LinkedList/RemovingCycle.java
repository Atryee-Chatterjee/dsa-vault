/*
Problem: Detect and Remove a Cycle in a Singly Linked List

Approach:
- Use Floyd's Cycle Detection Algorithm with slow and fast pointers
- If slow and fast meet, a cycle exists
- Move slow back to head and keep fast at the meeting point
- Move both pointers one step at a time to find the cycle's starting node
- Keep track of the node before fast using prev
- Set prev.next to null to remove the cycle
- Use isCycle() to verify whether the cycle exists

Complexity:
Time: O(n)
Space: O(1)

Key Idea:
- Floyd's algorithm detects the cycle without extra space
- The meeting-point technique helps locate the cycle's starting node
- Disconnecting the node before the cycle start removes the cycle
*/
package LinkedList;

public class RemovingCycle {
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

    public static void removeCycle() {
        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) { // Cycle exists
                cycle = true;
                break;
            }
        }
        if (cycle == false) { // Cycle doesn't exist
            return;
        }

        // Find meeting point
        slow = head;
        Node prev = null; // Last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // Remove cycle -> last.next = null
        prev.next = null;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // Create a cycle 1->2->3->2

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}
