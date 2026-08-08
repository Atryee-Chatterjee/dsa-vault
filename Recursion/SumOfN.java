/*
Problem: Find the sum of first n natural numbers using recursion

Definition:
- Sum of n natural numbers = n + (n-1) + (n-2) + ... + 1

Approach:
- Base case: If n == 1, return 1
- Recursive case:
  - Return n + sum(n - 1)
- Function keeps calling itself until it reaches 1

Complexity:
- Time: O(n)
- Space: O(n) (recursion stack)
*/
package Recursion;

import java.util.Scanner;

public class SumOfN {
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + sum(n - 1);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        sc.close();

        System.out.println(sum(n));
    }
}
