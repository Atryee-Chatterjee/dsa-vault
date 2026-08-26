/*
Problem: Grid Ways

Approach:
- Find the number of ways to reach the bottom-right cell of a grid
  by moving only Right or Down.

1. Recursive Approach:
- At each cell, make two choices:
  → Move Right
  → Move Down
- Base case:
  → If destination is reached, return 1
  → If boundary is crossed, return 0
- Total ways = Right ways + Down ways

2. Combinations Approach:
- Total moves required = (row - 1) + (col - 1)
- Choose (row - 1) Down moves from the total moves
- Formula:
  → C(row + col - 2, row - 1)
  → (row + col - 2)! / ((row - 1)! × (col - 1)!)

Complexity:
Recursive:
Time: O(2^(n+m))
Space: O(n+m)

Combinations:
Time: O(n+m) due to factorial recursion
Space: O(n+m) due to factorial recursion

Key Idea:
- Recursive approach explores every possible path
- Combinations approach directly calculates the number of paths
*/
package Backtracking;

public class GridWays {
    public static int gridWaysCombinations(int row, int col) { // TC - O(n+m)
        return factorial(row - 1 + col - 1) / (factorial(row - 1) * factorial(col - 1)); // Formula: C(n+m-2, n-1) =
                                                                                         // (n+m-2)! / ((n-1)! * (m-1)!)
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int gridWays(int i, int j, int row, int col) { // TC - O(2^(n+m)) SC - O(n+m) due to recursion stack
        // Base case
        if (i == row - 1 && j == col - 1) { // condition for last cell
            return 1;
        } else if (i == row || j == col) { // Boundary cross condition
            return 0;
        }
        int w1 = gridWays(i, j + 1, row, col); // Right
        int w2 = gridWays(i + 1, j, row, col); // Down

        return w1 + w2; // Total wasys
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(gridWaysCombinations(n, m));

    }
}
