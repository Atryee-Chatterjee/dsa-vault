/*
Problem: Sort an array using Heap Sort

Approach:
- Build a Max Heap from the given array
- The largest element is placed at the root
- Swap the root with the last element
- Reduce heap size and heapify the remaining elements
- Repeat until the array is sorted

Heapify:
- Compare the current element with its left and right children
- Find the largest element
- Swap if the largest element is not the root
- Recursively heapify the affected subtree

Complexity:
Time: O(n log n)
Space: O(log n) (recursion stack)

Key Idea:
- Max Heap gives the largest element at the root
- Repeatedly move the largest element to the end
- Uses a Divide/Heap-based sorting approach
*/
package SortingAlgorithms;

public class HeapSort {

    public static void heapSort(int arr[]) {

        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            // Move largest element to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the remaining elements
            heapify(arr, i, 0);
        }
    }

    // Maintains Max Heap property
    public static void heapify(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not the root
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {

        int arr[] = { 4, 5, 1, 2, 3 };

        heapSort(arr);
        printArr(arr);
    }
}