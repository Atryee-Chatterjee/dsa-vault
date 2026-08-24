/*
Problem: N-Queens

Approach:
- Place N queens on an N × N chessboard such that no two queens attack each other
- Use recursion and backtracking to try placing a queen in each row
- Before placing a queen, check whether the position is safe:
  → Check vertically upward
  → Check upper-left diagonal
  → Check upper-right diagonal
- If the position is safe:
  → Place the queen
  → Recursively move to the next row
  → Backtrack by removing the queen after the recursive call
- Base case:
  → When row == board.length, all queens are placed
  → Print the board and increase the solution count

Complexity:
Time: O(N!)
Space: O(N²) for the board + O(N) recursion stack

Key Idea:
- Place one queen per row
- Only check positions above the current row because previous rows
  already contain the placed queens
- Backtracking allows us to try different positions when a choice
  leads to an invalid solution
*/
package Backtracking;

public class Nqueens {
    static int count = 0;

    // Check whether a position is safe
    public static boolean isSafe(char board[][], int row, int col) {
        // Vertical up - (i+1, j)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Diagonal left - (i-1, j-1)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Diagonal right - (i-1, j+1)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("---------- Chess Board---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {
            printBoard(board);
            count++;

            return;
        }
        // place queen
        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }

    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        nQueens(board, 0);
        System.out.println("Total ways to solve N queens =  " + count);
    }
}
