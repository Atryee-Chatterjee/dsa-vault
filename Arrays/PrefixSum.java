/*
Problem: Maximum Subarray Sum (Prefix Sum Approach)

Approach:
- Create a prefix array where prefix[i] stores sum of elements from index 0 to i
- Use two loops to select start (i) and end (j) of subarray
- Calculate subarray sum using:
  sum = prefix[end] - prefix[start - 1] (if start > 0)
  else sum = prefix[end]
- Update maxSum with the maximum value found

Complexity:
Time: O(n^2)
Space: O(n)

Notes:
- Optimized version of brute-force (reduces one loop)
- Avoids recalculating sums repeatedly
- Works with negative numbers
- Further optimized solution is Kadane’s Algorithm (O(n))
 */
public class PrefixSum {
    public static void maxSubarraySum(int numbers[]) {
        int prefix[] = new int[numbers.length];
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        // Calculate prefix array
        prefix[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        System.out.println("Max subarray sum is :" + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 1, -2, 6, -1, 3 };
        maxSubarraySum(numbers);
    }
}
