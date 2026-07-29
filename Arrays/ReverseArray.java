/*
Problem: Reverse an Array

Approach:
- Use two pointers: start and end
- Swap elements at start and end
- Move start forward and end backward
- Repeat until start < end

Complexity:
Time: O(n)
Space: O(1)

Notes:
- In-place reversal (no extra array used)
- Efficient two-pointer technique
- Works for any type of array
 */
public class ReverseArray {
    public static void reverseArray(int arr[]) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 30, 60, 70, 80 };
        reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
