/*
Problem: Find the Next Greater Element for Each Array Element

Approach:
- Traverse the array from right to left
- Use a stack to store indices of potential greater elements
- Remove elements from the stack that are smaller than or equal to the current element
- If the stack is empty, no greater element exists, so store -1
- Otherwise, the top of the stack is the next greater element
- Push the current index into the stack

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack maintains useful greater elements
- Each element is pushed and popped at most once
- Traversing from right to left makes it easy to find the next greater element
*/
package Stacks;

import java.util.*;

public class NextGreaterElement {
    public static void nextGreaterElement(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            // Remove smaller elements from stack
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // Check and calculate greater element
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // Push idx in stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater[] = new int[arr.length];

        nextGreaterElement(arr, nextGreater);

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }

    }
}
