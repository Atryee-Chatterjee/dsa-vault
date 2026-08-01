/*
Problem: Bubble Sort

Approach:
- Repeatedly iterate through the array
- Compare adjacent elements and swap if they are in wrong order
- After each pass:
  → The largest element moves to its correct position at the end
- Reduce the range of comparison after each pass
- Use a swap flag:
  → If no swaps occur in a pass, array is already sorted → stop early

Complexity:
Time:
- Worst Case: O(n^2)
- Average Case: O(n^2)
- Best Case: O(n) (when array is already sorted, due to early exit)

Space: O(1)
*/
package SortingAlgorithms;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int trun = 0; trun < arr.length - 1; trun++) {
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - trun; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                System.out.println("Already Sorted");
                return;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        bubbleSort(arr);
        printArr(arr);
    }
}
