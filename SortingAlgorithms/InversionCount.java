/*
Problem: Inversion Count

Approach:
- Use the merge sort algorithm to divide the array into two halves
- Recursively count inversions in the left half
- Recursively count inversions in the right half
- Count cross-inversions while merging the two sorted halves
- If arr[i] > arr[j], count all remaining elements in the left half as inversions
- Merge both halves into a temporary array in sorted order
- Copy the sorted elements back into the original array
- Return the total inversion count

Complexity:
Time: O(n log n)
Space: O(n)
Here, n is the number of elements in the array.

Key Idea:
- An inversion exists when i < j and arr[i] > arr[j]
- Merge sort allows counting inversions efficiently during merging
- When an element from the right half is smaller than the current element in the left half, all remaining elements in the left half form inversions with it
- The array is also sorted as a side effect of counting inversions
*/
package SortingAlgorithms;

public class InversionCount {

    public static int merge(int arr[], int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        int invCount = 0;
        int temp[] = new int[right - left + 1];

        // Merge both halves and count inversions
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                invCount += (mid - i + 1);
                j++;
                k++;
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy sorted elements back to original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int arr[], int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half
            invCount += mergeSort(arr, left, mid);

            // Count inversions in right half
            invCount += mergeSort(arr, mid + 1, right);

            // Count inversions during merging
            invCount += merge(arr, left, mid, right);
        }
        return invCount;
    }

    public static int getInversions(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};

        System.out.println("Inversion Count = " + getInversions(arr));
    }
}
