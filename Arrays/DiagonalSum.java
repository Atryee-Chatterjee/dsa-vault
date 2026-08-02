/*
Problem: Diagonal Sum of a Matrix

Approach:
- We need to calculate the sum of:
  → Primary Diagonal (top-left to bottom-right)
  → Secondary Diagonal (top-right to bottom-left)

- Optimized Approach (O(n)):
  → Traverse only once using a single loop
  → For each index i:
      - Add primary diagonal element → matrix[i][i]
      - Add secondary diagonal element → matrix[i][n-1-i]
  → Avoid double counting:
      - If element lies in the center (i == n-1-i), add it only once

- Alternative Approach (O(n^2)):
  → Traverse entire matrix
  → Check conditions:
      - i == j → primary diagonal
      - i + j == n - 1 → secondary diagonal

Complexity:
Time:
- Optimized: O(n)
- Brute Force: O(n^2)

Space: O(1)

Notes:
- Works for square matrices only
- Key idea: diagonal indices follow simple patterns
- Avoid double counting the middle element in odd-sized matrices
*/
public class DiagonalSum {
    public static int diagonalSum(int matrix[][]){
        int sum=0;

        // for(int i=0; i<matrix.length; i++){ // O(n^2)
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(i == j){
        //             sum += matrix[i][j];
        //         }else if(i+j == matrix.length-1){
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++){ //O(n)
            // pd
            sum += matrix[i][i];
            // sd
            if(i != matrix.length-1-i)
                sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                            { 4, 5, 6 },
                            { 7, 8, 9 } };
        
        System.out.println(diagonalSum(matrix));
    }
}
