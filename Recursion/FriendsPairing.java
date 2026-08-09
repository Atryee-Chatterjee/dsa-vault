/*
Problem: Count ways to pair n friends (each can stay single or pair up)

Approach:
- Base case: If n == 1 or n == 2, return n
- Two choices:
  1. Stay single → friendsPairing(n-1)
  2. Pair with any of (n-1) friends → (n-1) * friendsPairing(n-2)
- Total ways = sum of both choices

Example:
Input: 3 → Output: 4

Complexity:
- Time: O(2^n)
- Space: O(n)

Key Idea:
- Combine single + pairing choices recursively
*/
package Recursion;

import java.util.Scanner;

public class FriendsPairing {
    public static int friendsPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // single
        // int fnm1 = friendsPairing(n - 1);
        // // pair
        // int fnm2 = (n - 1) * friendsPairing(n - 2);

        // int totalWays = fnm1 + fnm2;

        // return totalWays;

        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of friends: ");
        int n = sc.nextInt();

        System.out.println("Number of ways to pair friends: " + friendsPairing(n));
        sc.close();
    }
}
