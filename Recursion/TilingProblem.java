/*
Problem: Count ways to tile a 2×n floor using 2×1 tiles

Approach:
- Base case: If n == 0 or n == 1, return 1
- Two choices:
  1. Place tile vertically → tilingProblem(n-1)
  2. Place tiles horizontally → tilingProblem(n-2)
- Total ways = sum of both choices

Complexity:
- Time: O(2^n)
- Space: O(n)

Key Idea:
- Similar to Fibonacci pattern
- Break problem into smaller subproblems
*/
package Recursion;

import java.util.Scanner;

public class TilingProblem {
    public static int tilingProblem(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        // Vertical Choice
        // int fnm1 = tilingProblem(n-1);

        // // Horizontal Choice
        // int fnm2 = tilingProblem(n-2);
        
        // // Total Ways
        // int totalWays = fnm1 + fnm2;

        // return totalWays;

        return tilingProblem(n-1) + tilingProblem(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the floor size: ");
        int n = sc.nextInt();

        sc.close();
        System.out.println("Number of ways to tile the floor: " + tilingProblem(n));
    }
}
