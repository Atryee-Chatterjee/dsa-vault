/*
Problem: Print all indices of a given element (target) in an array using recursion

Approach:
- Traverse the array recursively using index
- Base case: If index reaches array length, stop recursion
- If current element matches target → print index
- Move to next index with recursive call

Example:
Input: arr = [3, 2, 4, 5, 6, 2, 7, 2, 2], target = 2
Output: 1 5 7 8

Complexity:
- Time: O(n)
- Space: O(n) (recursion stack)

Key Idea:
- Check each element and print matching indices during recursion
*/
package Recursion;

public class PrintAllOccurrences {
    public static void printAllOccurrences(int arr[], int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            System.out.print(index + " ");
        }
        printAllOccurrences(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        int target = 2;
        printAllOccurrences(arr, target, 0);
    }
}
