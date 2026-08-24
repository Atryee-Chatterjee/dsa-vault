/*
Problem: N-Queens – Find One Solution

Approach:
- Use recursion and backtracking to place one queen in each row
- Check whether each position is safe before placing a queen
- If a valid solution is found, return true immediately
- If a choice fails, remove the queen and try the next position
- Base case: all queens are successfully placed

Complexity:
Time: O(N!)
Space: O(N²) for the board + O(N) recursion stack

Key Idea:
- Unlike the N-Queens solution that counts all ways, this program stops
  as soon as it finds the first valid solution.
*/
package Backtracking;

public class NQueensOneSolution {

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
        System.out.println("-------- Chess Board ---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {
            return true;
        }
        // place queen
        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens(board, row + 1)){
                    return true;
                }
                board[row][j] = 'X';
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        // Initialization 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        if(nQueens(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }else{
            System.out.println("Solution is not possible");
        }
    }
}
