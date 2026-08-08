/*
Problem: Find the nth Fibonacci number using recursion

Definition:
- Fibonacci sequence:
  fib(0) = 0
  fib(1) = 1
  fib(n) = fib(n-1) + fib(n-2) for n > 1

Approach:
- Base case: If n == 0 or n == 1, return n
- Recursive case:
  - Calculate fib(n-1)
  - Calculate fib(n-2)
  - Return their sum

Complexity:
- Time: O(2^n) (very slow due to repeated calculations)
- Space: O(n) (recursion stack)

Notes:
- Can be optimized using memoization or dynamic programming
*/
package Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int nm1 = fib(n - 1);
        int nm2 = fib(n - 2);

        int fib = nm1 + nm2;

        return fib;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the range: ");
        int n = sc.nextInt();

        sc.close();

        System.out.println(fib(n));
    }
}
