/*
Problem: Print numbers from n to 1 using recursion

Approach:
- Base case: If n == 1, print 1 and return
- Print current number n first
- Then make recursive call with (n-1)
- This ensures numbers are printed in decreasing order

Example:
Input: 10
Output: 10 9 8 7 6 5 4 3 2 1

Complexity:
Time: O(n)
Space: O(n) (recursion stack)

Notes:
- Printing happens before recursive call
- Demonstrates recursion in forward (top-down) phase
*/
package Recursion;

public class PrintDecreasing {
    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void main(String[] args) {
        printDec(10);
    }
}
