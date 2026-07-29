/*
Problem: Print All Subarrays and Their Sum

Approach:
- Use three loops
- First loop selects the starting index
- Second loop selects the ending index
- Third loop prints elements from start to end (subarray)
- Calculate sum of each subarray while printing
- Count total number of subarrays

Complexity:
Time: O(n^3)
Space: O(1)

Notes:
- Subarray = continuous part of an array
- Total subarrays = n*(n+1)/2
- Brute-force approach (not optimized)
- Can be optimized using prefix sum (O(n^2))
 */
public class PrintSubarrays {
    public static void printSubarrays(int arr[]) {
        int totalSubarrays = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.print(" - Sum of this subarray is = " + sum);
                sum = 0;
                totalSubarrays++;

                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total numbers of subarrays = " + totalSubarrays);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 8, 3, 7 };
        printSubarrays(arr);
    }
}