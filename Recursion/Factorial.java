/*
Problem: Find the factorial of a number using recursion

Definition:
- Factorial of n (n!) = n * (n-1) * (n-2) * ... * 1
- Special case: 0! = 1

Approach:
- Base case: If n == 0, return 1
- Recursive case: Multiply n with factorial(n - 1)
- The function keeps calling itself until it reaches 0

Example:
Input: 5
Output: 120
Explanation:
factorial(5) = 5 * 4 * 3 * 2 * 1 = 120

Complexity:
- Time: O(n)
- Space: O(n) (due to recursion call stack)
*/
package Recursion;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = n * factorial(n - 1);
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        sc.close();

        System.out.println(factorial(n));
    }
}
