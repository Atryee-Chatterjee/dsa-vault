/*
Problem: Print Matrix in Spiral Order

Approach:
- Use four boundaries to track the current layer:
  → startRow, endRow
  → startCol, endCol
- Traverse the matrix in layers (outer to inner)

- In each iteration:
  → Print Top row (left → right)
  → Print Right column (top → bottom)
  → Print Bottom row (right → left)
      - Only if startRow != endRow (to avoid duplicate row)
  → Print Left column (bottom → top)
      - Only if startCol != endCol (to avoid duplicate column)

- After completing one layer:
  → Move boundaries inward:
      startRow++, startCol++
      endRow--, endCol--

- Repeat until all layers are traversed

Complexity:
Time: O(n * m)
Space: O(1)

Notes:
- Works for both square and rectangular matrices
- Boundary checks prevent duplicate printing
- Key idea: process matrix layer by layer (spiral traversal)
*/
public class SpiralMatrix {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + ", ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + ", ");
            }
            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + ", ");
            }
            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + ", ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        printSpiral(matrix);
    }
}
