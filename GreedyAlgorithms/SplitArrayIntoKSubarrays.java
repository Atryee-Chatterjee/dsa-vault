/*
Problem: Split Array into K Subarrays

Approach:
- Find the search range for the answer
- Set the lower bound as the maximum element in the array
- Set the upper bound as the sum of all array elements
- Apply binary search to find the minimum possible maximum subarray sum
- Use isPossible() to check whether the array can be split into at most K subarrays
- Traverse the array and add elements while the current sum does not exceed maxSum
- If adding an element exceeds maxSum, start a new subarray
- If the number of subarrays exceeds K, return false
- If splitting is possible, store the answer and search for a smaller maximum sum

Complexity:
Time: O(n * log(sum))
Space: O(1)
Here, n is the number of elements and sum is the total sum of the array.

Key Idea:
- Use binary search on the possible maximum subarray sum
- Greedily create subarrays while keeping their sums within the given limit
- If a limit requires more than K subarrays, increase the limit
- If a limit is valid, try a smaller limit to minimize the maximum subarray sum
*/
package GreedyAlgorithms;

public class SplitArrayIntoKSubarrays {

    // Check whether the array can be split into at most K subarrays
    public static boolean isPossible(int arr[], int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {

            if (currentSum + arr[i] <= maxSum) {
                currentSum += arr[i];
            } else {
                subarrays++;
                currentSum = arr[i];
            }

            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }

    public static int splitArray(int arr[], int k) {
        int low = 0;
        int high = 0;

        // Find the search range
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int ans = high;

        // Binary search for the minimum possible maximum sum
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int k = 3;

        System.out.println("Minimum Largest Subarray Sum: "
                + splitArray(arr, k));
    }
}
