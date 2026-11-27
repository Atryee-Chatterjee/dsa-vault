/*
Problem: Knight's Tour

Approach:
- Initialize an N x N chessboard with all cells marked as unvisited (-1)
- Place the knight at the starting position (0, 0) and mark it as move 0
- Use recursive backtracking to visit every square exactly once
- Try all 8 possible moves of the knight at each step
- Use isSafe() to check whether the next position is within the board and unvisited
- Mark a valid position with the current move number
- Recursively continue with the next move
- If a move does not lead to a solution, backtrack by marking the cell as unvisited again
- If all N * N squares are visited, print the solution

Complexity:
Time: O(8^(N*N))
Space: O(N*N)
Here, N is the size of the chessboard.

Key Idea:
- Use Backtracking to explore all possible knight moves
- Visit each square exactly once
- Undo a move when it does not lead to a complete tour
- Stop when all squares have been successfully visited
*/
package Backtracking;

public class KnightsTour {

    static int N = 8;

    // Possible moves of a knight
    static int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    // Check whether the knight can move to this cell
    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    // Print the solution
    public static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Recursive backtracking function
    public static boolean solveKTUtil(int x, int y, int movei, int sol[][]) {

        // All squares have been visited
        if (movei == N * N) {
            return true;
        }

        // Try all 8 possible knight moves
        for (int k = 0; k < 8; k++) {

            int nextX = x + xMove[k];
            int nextY = y + yMove[k];

            if (isSafe(nextX, nextY, sol)) {

                sol[nextX][nextY] = movei;

                if (solveKTUtil(nextX, nextY, movei + 1, sol)) {
                    return true;
                }

                // Backtrack if the move does not lead to a solution
                sol[nextX][nextY] = -1;
            }
        }

        return false;
    }

    // Initialize the board and start the tour
    public static void solveKT() {

        int sol[][] = new int[N][N];

        // Mark all cells as unvisited
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        // Knight starts from cell (0, 0)
        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(sol);
        }
    }

    public static void main(String[] args) {
        solveKT();
    }
}
