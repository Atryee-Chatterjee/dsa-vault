/*
Problem: Print numbers from 1 to n using recursion

Approach:
- Base case: If n == 1, print 1 and return
- Recursive call: First call function with (n-1)
- Then print current number n
- This ensures numbers are printed in increasing order

Complexity:
Time: O(n)
Space: O(n) (due to recursion stack)

Notes:
- Uses recursion instead of loops
- Printing happens during backtracking phase
*/
package Recursion;

public class PrintIncreasing {
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        printInc(5);
    }
}
