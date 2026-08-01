/*
Problem: Selection Sort

Approach:
- Divide the array into two parts:
  → Sorted part (left side)
  → Unsorted part (right side)
- For each position i:
  → Assume current index as minimum (minPos = i)
  → Traverse remaining unsorted array to find actual minimum element
  → Update minPos if a smaller element is found
- After finding the minimum:
  → Swap it with the current position (i)
- Repeat until entire array is sorted

Complexity:
Time:
- Worst Case: O(n^2)
- Average Case: O(n^2)
- Best Case: O(n^2) (no early exit optimization)

Space: O(1)

Notes:
- Performs fewer swaps compared to Bubble Sort
*/
package SortingAlgorithms;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            // Swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        selectionSort(arr);
        printArr(arr);
    }
}
