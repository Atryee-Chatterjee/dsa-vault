/*
Problem: Insertion Sort

Approach:
- Divide the array into two parts:
  → Sorted part (left side)
  → Unsorted part (right side)
- Start from the second element (i = 1)
- For each element:
  → Store current element (curr)
  → Compare it with elements in the sorted part (left side)
  → Shift all elements greater than curr one position to the right
- Insert curr at its correct position
- Repeat until the entire array is sorted

Complexity:
Time:
- Worst Case: O(n^2) (array sorted in reverse)
- Average Case: O(n^2)
- Best Case: O(n) (array already sorted)

Space: O(1)

Notes:
- Works similar to sorting playing cards in hand
*/
package SortingAlgorithms;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // Fining out the correct position to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // Insertion
            arr[prev + 1] = curr;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        insertionSort(arr);
        printArr(arr);
    }
}
