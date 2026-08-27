/*
Problem: Sudoku Solver

Approach:
- Use recursion and backtracking to fill the empty cells (0).
- Check whether a digit is safe by checking:
  → Current column
  → Current row
  → 3 × 3 grid
- Try digits 1 to 9 in each empty cell.
- If a choice leads to a solution, return true.
- If it fails, reset the cell to 0 and try the next digit.
- Base case: when all rows are completed, the Sudoku is solved.

Complexity:
Time: O(9^(n²)) in the worst case
Space: O(n²) for the board + O(n²) recursion stack

Key Idea:
- Try → Recursively solve → Backtrack if needed.

Output:
2 1 8 | 3 9 6 | 7 4 5 
4 9 6 | 1 5 7 | 8 3 2 
7 5 3 | 2 8 4 | 1 9 6 
-------------------------
1 8 5 | 7 6 3 | 4 2 9 
3 7 4 | 9 2 8 | 5 6 1 
9 6 2 | 4 1 5 | 3 7 8 
-------------------------
5 3 1 | 6 7 2 | 9 8 4 
6 4 9 | 8 3 1 | 2 5 7 
8 2 7 | 5 4 9 | 6 1 3 
*/
package Backtracking;

public class SudokuSolver {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // Row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // Grid 3 * 3
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true; // Safe
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case
        if (row == 9) {
            return true;
        }

        // Recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) { // Place digit
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) { // Solution exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }
    public static void printSudoku(int sudoku[][]) {
    for (int i = 0; i < 9; i++) {

        if (i % 3 == 0 && i != 0) {
            System.out.println("-------------------------");
        }

        for (int j = 0; j < 9; j++) {

            if (j % 3 == 0 && j != 0) {
                System.out.print("| ");
            }

            System.out.print(sudoku[i][j] + " ");
        }

        System.out.println();
    }
}

    public static void main(String[] args) {
        
        int[][] sudoku = {
            { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
            { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
            { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
            { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
            { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
            { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
            { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
            { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
            { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
