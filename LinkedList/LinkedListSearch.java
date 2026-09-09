/*
Problem: Search for an Element in a Singly Linked List

Approach:

- Iterative Search:
  - Traverse the linked list from head to tail
  - Compare each node's data with the key
  - Return the index if the key is found
  - Return -1 if the key is not found

- Recursive Search:
  - Recursively search the next node
  - Return 0 when the key is found
  - Add 1 to the returned index while returning from recursion
  - Return -1 if the key is not found

Complexity:

Iterative Search: Time O(n), Space O(1)

Recursive Search: Time O(n), Space O(n)

Key Idea:

- Iterative search uses a loop to traverse the list
- Recursive search uses the call stack to traverse the list
*/
package LinkedList;

public class LinkedListSearch {
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

    public int itrSearch(int key) { // O(n)
        int i = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("key found at index " + i);
                return i;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Key not found");
        return -1;
    }

    public int helper(Node head, int key) { //O(n)
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public static void main(String[] args) {
        LinkedListSearch ll = new LinkedListSearch();
        System.out.println(ll.itrSearch(5));
    }
}
