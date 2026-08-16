/*
Problem: Search in Rotated Sorted Array

Approach:
- Use modified Binary Search with recursion
- Find the middle element
- If mid element == target → return its index
- Check which half of the array is sorted:
  → If left half is sorted:
      - If target lies in the left half → search left
      - Else → search right
  → Else, right half is sorted:
      - If target lies in the right half → search right
      - Else → search left
- Repeat until target is found or search range becomes invalid

Complexity:
Time: O(log n)
Space: O(log n) due to recursion stack

Key Idea:
- In a rotated sorted array, at least one half is always sorted
- Use the sorted half to decide which part to search
- Each recursive call eliminates half of the search space
*/
package SortingAlgorithms;

public class SearchInRotatedSortedArray {
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        // find mid
        int mid = si + (ei - si) / 2;

        // case FOUND
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a : left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            }
            // case b : right
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }
        // mid on L2
        else {
            if (arr[ei] <= tar && tar >= arr[mid]) {
                // case c : right
                return search(arr, tar, mid + 1, ei);
            } else {
                // case d : left
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;
        int idx = search(arr, target, 0, arr.length - 1);
        System.out.println(idx);
    }
}
