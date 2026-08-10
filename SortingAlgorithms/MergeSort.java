/*
Problem: Sort an array using Merge Sort algorithm

Approach (Divide & Conquer):
1. Divide:
   - Recursively split the array into two halves until single elements remain

2. Conquer:
   - Sort each half recursively

3. Combine (Merge step):
   - Merge two sorted halves into a single sorted array using a temporary array

Functions:
- mergeSort(arr, si, ei):
  → Recursively divides the array
- merge(arr, si, ei, mid):
  → Merges two sorted subarrays:
     Left:  si → mid
     Right: mid+1 → ei

Complexity:
- Time: O(n log n)
- Space: O(n) (extra array for merging)
*/
package SortingAlgorithms;

public class MergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid); // Left part
        mergeSort(arr, mid + 1, ei); // Right part
        merge(arr, si, ei, mid);
    }

    // merge function to merge two sorted arrays
    public static void merge(int arr[], int si, int ei, int mid) {
        int temp[] = new int[ei - si + 1];

        int i = si;// index for left sorted part
        int j = mid + 1; // index for right sorted part
        int k = 0; // index for temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // For leftover elements in the Left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // For leftover elements in the Right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // Copy temp to original array
        for (k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
