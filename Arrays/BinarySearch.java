/*
Problem: Binary Search

Approach:
- Initialize start and end pointers
- Find the middle element
- If key == middle → return index
- If key > middle → search right half
- If key < middle → search left half
- Repeat until start > end

Complexity:
Time: O(log n)
Space: O(1)

Notes:
- Works only on sorted arrays
- Much faster than linear search for large data
- Divide and conquer technique
 */
public class BinarySearch {

    public static void binarySearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                System.out.println("Key found at index " + mid); // found
                return;
            } else if (arr[mid] < key) {
                start = mid + 1; // search right side
            } else {
                end = mid - 1; // search left side
            }
        }

        System.out.println("Key not found!"); // not found

    }

    public static void main(String[] args) {
        int arr[] = { 10, 30, 60, 70, 80 }; // sorted array

        binarySearch(arr, 30);
    }
}