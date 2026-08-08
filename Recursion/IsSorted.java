/*
Problem: Check if an array is sorted in ascending order using recursion

Approach:
- Start checking from index i (initially 0)
- Base case: If i reaches the last index (arr.length - 1), return true
  → This means all elements are checked and array is sorted
- If current element is greater than next element (arr[i] > arr[i+1]),
  return false (array is not sorted)
- Otherwise, recursively check the next pair by calling isSorted(arr, i + 1)

Complexity:
- Time: O(n)
- Space: O(n) (recursion stack)

Notes:
- Checks elements pair-by-pair
- Stops early if any unsorted pair is found
*/
package Recursion;

public class IsSorted {
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(arr, 0));
    }
}
