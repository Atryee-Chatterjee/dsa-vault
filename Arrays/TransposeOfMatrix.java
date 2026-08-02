/*
Problem: Transpose of a Matrix (Using New Matrix)

Approach:
- Transpose means converting rows into columns:
  → matrix[i][j] becomes transpose[j][i]

- Steps:
  → Find number of rows and columns of original matrix
  → Create a new matrix with swapped dimensions:
      - rows → columns
      - columns → rows
  → Traverse original matrix using nested loops:
      - For each element:
          transpose[j][i] = matrix[i][j]
  → Return the new transpose matrix

- Printing:
  → Use a helper function to print both original and transposed matrix

Complexity:
Time: O(n * m)
Space: O(n * m)

Notes:
- Works for both square and rectangular matrices
- Cannot be done in-place for non-square matrices
- Key idea: swap indices (i, j) → (j, i)
*/
public class TransposeOfMatrix {
    public static int[][] transpose(int matrix[][]) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create transpose matrix with swapped dimensions
        int[][] transpose = new int[cols][rows];

        // Fill transpose matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int matrix[][] = {
                { 11, 12, 13 },
                { 21, 22, 23 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] result = transpose(matrix);

        System.out.println("Transpose Matrix:");
        printMatrix(result);
    }
}