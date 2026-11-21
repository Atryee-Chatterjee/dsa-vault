/*
Problem: Kth Largest Odd Number in a Given Range

Approach:
- Extract the left (L) and right (R) boundaries from the range
- Check if K is valid (K must be greater than 0)
- Determine whether R is odd or even
- Calculate the number of odd numbers in the given range
- If K exceeds the number of odd numbers, return 0
- Use a mathematical formula to find the Kth largest odd number without iteration

Complexity:
Time: O(1)
Space: O(1)

Key Idea:
- Odd numbers are separated by a difference of 2
- Start from the largest odd number in the range and move backward by 2 for each position
- Use bitwise AND (& 1) to check whether a number is odd
- Find the answer directly using a formula instead of traversing the range
*/
package GreedyAlgorithms;

public class KthLargestOddNumber {

    public static int kthOdd(int range[], int K) {
        int L = range[0];
        int R = range[1];

        // Invalid K
        if (K <= 0) {
            return 0;
        }

        // If R is odd
        if ((R & 1) != 0) {
            int count = (R - L + 1) / 2;

            // Check if K exceeds the number of odd numbers
            if (K > count) {
                return 0;
            } else {
                return R - 2 * K + 2;
            }
        }

        // If R is even
        else {
            int count = (R - L + 1) / 2;

            if (K > count) {
                return 0;
            } else {
                return R - 2 * K + 1;
            }
        }
    }

    public static void main(String[] args) {
        int range[] = { -10, 10 };
        int K = 8;

        System.out.println(kthOdd(range, K));
    }
}
