/*
Problem: Change Array Elements Using Backtracking

Approach:
- Use recursion to traverse every index of the array
- Continue recursively until the end of the array
- Base case:
  → When i reaches arr.length, print the array
- After the recursive call returns, use backtracking to modify arr[i]
- The changes made while returning from recursion demonstrate backtracking

Complexity:
Time: O(n)
Space: O(n) due to recursion stack

Key Idea:
- Recursion moves forward through the array
- Backtracking modifies elements while returning from recursive calls
*/
package Backtracking;

public class ChangeArrayElements {
    public static void changeArray(int arr[], int i, int val) {
        // Base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        // Recursion
        changeArray(arr, i + 1, val + 1);
        // Backtracking
        arr[i] = arr[i] - 2;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        changeArray(arr, 0, 1);
        printArr(arr);
    }
}
