/*
Problem: Find Maximum and Minimum in a 2D Array

Approach:
- Initialize two variables:
  → max = smallest possible value (Integer.MIN_VALUE)
  → min = largest possible value (Integer.MAX_VALUE)
- Traverse the entire 2D array using nested loops:
  → For each element:
      - Update max using Math.max()
      - Update min using Math.min()
- After traversal:
  → max holds the largest element
  → min holds the smallest element
- Print both values

Complexity:
Time: O(n * m)  (n = rows, m = columns)
Space: O(1)

Notes:
- Works for any rectangular 2D array
- No need for sorting → efficient approach
- Uses built-in Math functions for simplicity
- Input is taken dynamically using Scanner
*/
import java.util.Scanner;

public class MaxAndMinNumIn2Darray {
    public static void maxAndMinNum(int arr[][]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
               max = Math.max(max, arr[i][j]);
               min = Math.min(min, arr[i][j]);
            }
        }
        System.out.println("Maximum element is " + max);
        System.out.println("Minimum element is " + min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2D array's row size");
        int n = sc.nextInt();
        System.out.println("Enter 2D array's column size");
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        System.out.println("Enter Array elements");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " "); 
            }
            System.out.println();
        }

        maxAndMinNum(arr);
        sc.close();
    }
}
