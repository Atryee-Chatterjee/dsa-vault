/*
Problem: Maximum Subarray Sum (Brute Force)

Approach:
- Use three nested loops
- First loop selects starting index (i)
- Second loop selects ending index (j)
- Third loop calculates sum of subarray from i to j
- Update maxSum with the maximum of current sum and previous max

Complexity:
Time: O(n^3)
Space: O(1)

Notes:
- Checks all possible subarrays
- Works even with negative numbers
- Inefficient for large inputs
- Can be optimized using prefix sum (O(n^2)) or Kadane’s Algorithm (O(n))
 */
public class MaxSubarraySum {
    public static void maxSubarraySum(int numbers[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                currSum=0;
                for(int k=i; k<=j; k++){
                    currSum += numbers[k]; 
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println("Max subarray sum is :" + maxSum );
    }
    public static void main(String[] args) {
        int numbers[] = { 1, -2, 6, -1, 3};
        maxSubarraySum(numbers);

    }
    
}
