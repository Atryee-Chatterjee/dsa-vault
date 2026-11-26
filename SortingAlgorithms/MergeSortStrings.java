/*
Problem: Merge Sort for Strings

Approach:
- Divide the string array into two halves recursively
- Continue dividing until each subarray contains only one element
- Merge the two sorted halves using a separate merge() method
- Compare strings alphabetically using compareTo()
- Place the smaller string into the temporary array
- Copy the remaining elements from both halves
- Return the merged array in sorted order

Complexity:
Time: O(n log n)
Space: O(n)
Here, n is the number of strings in the array.

Key Idea:
- Use the Divide and Conquer approach to sort strings
- Divide the array into smaller subarrays and sort them recursively
- Use compareTo() to compare strings lexicographically
- Merge the sorted subarrays to obtain the final sorted array
*/
package SortingAlgorithms;

public class MergeSortStrings {

    // Divide the array into smaller halves
    public static String[] mergeSort(String arr[], int lo, int hi) {

        if (lo == hi) {
            return new String[]{arr[lo]};
        }

        int mid = lo + (hi - lo) / 2;

        String arr1[] = mergeSort(arr, lo, mid);
        String arr2[] = mergeSort(arr, mid + 1, hi);

        return merge(arr1, arr2);
    }

    // Merge two sorted arrays
    public static String[] merge(String arr1[], String arr2[]) {
        int m = arr1.length;
        int n = arr2.length;

        String arr3[] = new String[m + n];

        int i = 0;
        int j = 0;
        int idx = 0;

        // Compare strings alphabetically
        while (i < m && j < n) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                arr3[idx++] = arr1[i++];
            } else {
                arr3[idx++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < m) {
            arr3[idx++] = arr1[i++];
        }

        while (j < n) {
            arr3[idx++] = arr2[j++];
        }

        return arr3;
    }

    public static void main(String[] args) {
        String arr[] = {"sun", "earth", "mars", "mercury"};

        String sorted[] = mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}
