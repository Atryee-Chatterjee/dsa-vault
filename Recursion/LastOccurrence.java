/*
Problem: Find the last occurrence of a given key in an array using recursion

Approach:
 - Start from index i (initially 0)
 - Base case: if i reaches end of array, return -1
 - Recursively search in remaining array (i + 1)
 - If not found ahead and current element matches key, return i
 - Otherwise return result from recursive call

Complexity:
- Time: O(n)
- Space: O(n) (recursion stack)

Notes:
- Recursion goes till end first, then checks while coming back
- This ensures the LAST occurrence is returned, not the first
*/
package Recursion;

public class LastOccurrence {
    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 6 };
        System.out.println(lastOccurence(arr, 3, 0));
    }
}
