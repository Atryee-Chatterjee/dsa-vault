/*
Problem: Staircase Search in a Sorted 2D Matrix

Approach:
- The matrix is sorted:
  → Rows are sorted left → right
  → Columns are sorted top → bottom

- Start from the top-right corner:
  → row = 0, col = n - 1

- At each step:
  → If current element == key:
      - Key found → return its index
  → If key < current element:
      - Move left (col--)
  → Else (key > current element):
      - Move down (row++)

- Repeat until:
  → Key is found OR
  → Indices go out of bounds

Complexity:
Time: O(n + m)
Space: O(1)

Notes:
- Eliminates one row or one column in each step
- More efficient than brute force (O(n*m))
- Works only when matrix is row-wise and column-wise sorted
*/
public class StairCaseSearch {
    public static void stairCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix.length - 1;

        while (row < matrix.length && col >= 0) { //O(n+m)
            if (matrix[row][col] == key) {
                System.out.println("Key found at index " + "(" + row + "," + col + ")");
                return;
            }
            if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found!");
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        
        stairCaseSearch(matrix, 10);
    }
}
