/*
Problem: Find All Occurrences of an Element in an Array

Approach:
- Traverse the array recursively using the index i
- If the current element matches the key, print its index
- Move to the next index using recursion
- Stop when the end of the array is reached

Example:
Input: arr = {3,2,4,5,6,2,7,2,2}, key = 2
Output: 1 5 7 8

Complexity:
Time: O(n)
Space: O(n) due to recursion stack

Key Idea:
- Check each element recursively
- Print every index where the key is found
*/
package Recursion;

public class FindAllOccurrences {
    public static void allOccurences(int arr[],int key,int i) {
        if(i ==  arr.length){
            return;
        }

        if(arr[i] == key){
            System.out.print(i + " ");
        }
        allOccurences(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        int key = 2;
        allOccurences(arr, key, 0);
    }
}
