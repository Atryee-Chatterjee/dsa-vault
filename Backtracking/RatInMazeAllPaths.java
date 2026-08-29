/*
 Rat in a Maze — Find All Possible Paths using Backtracking

 Approach:
 - Start from (0,0) and try to reach (N-1,N-1).
 - Use a solution matrix to mark the current path.
 - From each cell, recursively try all 4 directions: Down, Right, Up, Left.
 - If the destination is reached, print the current path and increment count.
 - If a path fails, unmark the cell and backtrack to explore other paths.
 - The sol[][] matrix prevents revisiting cells in the current path.

 Time Complexity: O(4^(N²)) in the worst case
 Space Complexity: O(N²) for solution matrix + O(N²) recursion stack
*/
package Backtracking;

public class RatInMazeAllPaths {
    static int count = 0;

    public static void printMaze(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        // Check boundary and whether the cell is open
        return (x >= 0 && x < maze.length &&
                y >= 0 && y < maze.length &&
                maze[x][y] == 1);
    }

    public static void solveMazeUtil(int maze[][], int x, int y, int sol[][]) {

        // Base Case: destination reached
        if (x == maze.length - 1 && y == maze.length - 1) {
            sol[x][y] = 1;

            // Print the current solution
            printMaze(sol);
            System.out.println();
            count++;

            // Backtrack from destination
            sol[x][y] = 0;
            return;
        }

        // Check if current cell is safe
        if (isSafe(maze, x, y)) {

            // Already visited
            if (sol[x][y] == 1) {
                return;
            }

            // Choose current cell
            sol[x][y] = 1;

            // Try moving Down
            solveMazeUtil(maze, x + 1, y, sol);

            // Try moving Right
            solveMazeUtil(maze, x, y + 1, sol);

            // Try moving Up
            solveMazeUtil(maze, x - 1, y, sol);

            // Try moving Left
            solveMazeUtil(maze, x, y - 1, sol);

            // Backtrack: unchoose current cell
            sol[x][y] = 0;
        }
    }

    public static void solveMaze(int maze[][]) {

        int n = maze.length;
        int sol[][] = new int[n][n];

        solveMazeUtil(maze, 0, 0, sol);
    }

    public static void main(String[] args) {

        int maze[][] = {
                    { 1, 1, 0, 0 },
                    { 1, 1, 1, 0 },
                    { 0, 1, 1, 1 },
                    { 0, 0, 1, 1 }
                };

        solveMaze(maze);
        System.out.println("Total possible paths that the rat can take to reach from source to destination in the maze =  " + count);
    }
}

