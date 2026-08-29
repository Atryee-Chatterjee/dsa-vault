/*
Rat in a Maze — Backtracking

Approach:
- Start from (0,0) and try to reach the destination (N-1,N-1).
- Use a solution matrix to mark the current path.
- At each cell, try moving Down and Right recursively.
- If a path fails, unmark the cell and backtrack to try another path.

Key Steps:
1. Check if the cell is safe and not already visited.
2. Mark the cell as part of the path.
3. Recursively try Down and Right.
4. If both fail, unmark the cell (backtrack).
5. Mark the destination and return true when reached.

Time Complexity: O(2^(N²)) in the worst case
Space Complexity: O(N²) for the solution matrix + recursion stack.
*/
package Backtracking;

public class RatInMaze {
    public static void printMaze(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false / checks boundary
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        // Base Case: destination reached
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        // Check if current cell is valid and safe
        if (isSafe(maze, x, y) == true) {

            // Already visited
            if (sol[x][y] == 1) {
                return false;
            }
            // Choose current cell
            sol[x][y] = 1;

            // Try moving Down
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            // Try moving Right
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            // Backtrack: unchoose current cell
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static boolean solveMaze(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];

        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution does not exists");
            return false;
        }

        printMaze(sol);
        return true;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        solveMaze(maze);
    }
}
