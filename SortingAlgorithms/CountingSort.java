/*
Problem: Counting Sort

Approach:
- Find the largest element in the array
  → This determines the size of the count array
- Create a count array of size (largest + 1)
- Traverse the original array:
  → Store frequency of each element in count array
- Reconstruct the sorted array:
  → For each index in count array:
      - While count[i] > 0:
          → Place i into original array
          → Decrease count[i]
- This results in a sorted array

Complexity:
Time:
- Worst Case: O(n + k)
- Average Case: O(n + k)
- Best Case: O(n + k)
  (where n = number of elements, k = range of values)

Space: O(k)

Notes:
- Works only for non-negative integers
*/
package SortingAlgorithms;

public class CountingSort {
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // count frequency
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        countingSort(arr);
        printArr(arr);
    }
}
