/*
Problem: Check if a Singly Linked List is a Palindrome

Approach:
- Use slow and fast pointers to find the middle node
- Reverse the second half of the linked list
- Compare the first half with the reversed second half
- Return false if any values do not match
- Return true if all values match

Complexity:
Time: O(n)
Space: O(1)

Key Idea:
- Find the middle using slow and fast pointers
- Reverse the second half and compare both halves
*/
package LinkedList;

public class PalindromeCheck {
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

    // Slow and Fast Approach
    public Node findMid(Node head) { // helper func
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my midNode
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1 - Find mid
        Node midNode = findMid(head);

        // Step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step3 - check if equal, 1st half == 2nd half values
        Node left = head;
        Node right = prev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
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

    public static void main(String[] args) {
        PalindromeCheck ll = new PalindromeCheck();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        System.out.println(ll.checkPalindrome());
    }
}
