/*
Problem: Tower of Hanoi

Approach:
- Use recursion to move n disks from source to destination
- Base case:
  → If n == 1, directly move the disk from source to destination
- Recursive steps:
  → Move n-1 disks from source to helper using destination
  → Move the nth disk from source to destination
  → Move n-1 disks from helper to destination using source

Complexity:
Time: O(2^n)
Space: O(n) due to recursion stack

Key Idea:
- To move n disks, first move n-1 disks out of the way
- Move the largest disk to the destination
- Then move the n-1 disks onto the largest disk
- Minimum moves required = 2^n - 1
*/
package Recursion;

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }

        // transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n - 1, src, dest, helper);

        // transfer nth from src to dest
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);

        // transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, "A", "B", "C");
    }
}
