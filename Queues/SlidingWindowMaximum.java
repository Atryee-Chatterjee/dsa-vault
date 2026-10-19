/*
Problem: Find the Maximum Element in Each Sliding Window

Approach:
- Use a deque to store indices of elements in decreasing order of their values
- Traverse the array from left to right
- Remove indices that fall outside the current window
- Remove indices from the back whose values are less than or equal to the current element
- Add the current index to the back of the deque
- Once the first window is formed, store the front element's value as the maximum

Complexity:
Time: O(n)
Space: O(k)

Key Idea:
- The deque maintains indices of potential maximum elements
- The front always contains the index of the maximum element in the current window
- Each index is added and removed at most once
*/
package Queues;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() &&
                   arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store maximum after the first window is formed
            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(
            Arrays.toString(maxSlidingWindow(arr, k))
        );
    }
}
