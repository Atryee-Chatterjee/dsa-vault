/*
Problem: Sort an array using Quick Sort

Approach:
- Choose the last element as the pivot
- Partition the array around the pivot:
  → Traverse the array using j
  → If arr[j] <= pivot:
      - Increment i
      - Swap arr[i] and arr[j]
  → After the loop, swap the pivot with arr[i + 1]
- This places the pivot at its correct position
- Recursively apply Quick Sort to the left and right parts

Complexity:
Average Time: O(n log n)
Worst Time: O(n²)
Space: O(log n) average (recursion stack)

Key Idea:
- Swapping places smaller elements before the pivot
- After partitioning, the pivot is in its correct position
- Recursively sort the left and right subarrays
*/
package SortingAlgorithms;

public class QuickSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // left
        quickSort(arr, pIdx + 1, ei); // right

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make space for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3, -2 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
