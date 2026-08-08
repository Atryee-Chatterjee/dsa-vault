/*
 * Problem: Find the first occurrence of a given key in an array using recursion
 *
 * Approach:
 * - Start from index i (initially 0)
 * - Base case: if i reaches the end of the array, return -1 (key not found)
 * - If current element matches the key, return current index
 * - Otherwise, recursively search in the next index (i + 1)
 *
 * Complexity:
 * - Time: O(n)
 * - Space: O(n) (recursion stack)
 *
 * Note:
 * - This approach checks elements while going forward
 * - Hence, it returns the FIRST occurrence of the key
 */
package Recursion;

public class FirstOccurrence {
    public static int firstOccurence(int arr[], int key, int i){
        if( i == arr.length){
            return -1;
        }
        if(key == arr[i]){
            return i ;
        }
        return firstOccurence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 6 };
        System.out.println(firstOccurence(arr, 6, 0));
    }
}
