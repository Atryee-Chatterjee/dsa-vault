/*
Problem: Maximum Subarray Sum (Kadane’s Algorithm - Improved Version)

Approach:
- Start from the first element instead of 0
- At each step, decide:
  → Start a new subarray from current element
  → OR continue the previous subarray
- Use:
  currSum = max(current element, currSum + current element)
- Update maxSum at every step

Complexity:
Time: O(n)
Space: O(1)

Notes:
- Handles all-negative arrays correctly (unlike basic Kadane’s)
- No need to reset sum to 0
- More optimal and widely used in interviews
*/
public class KadanesAlgorithm {

    public static void kadanes(int numbers[]) {
        int currSum = numbers[0]; // start from first element
        int maxSum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            currSum = Math.max(numbers[i], currSum + numbers[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println("Max subarray sum is : " + maxSum);
    }

    public static void main(String[] args) {
        // int numbers[] = { -5, -2, -3, -1 }; // all negative
        // int numbers[] = { 1, 3, 4, 6 }; // all positive
        int numbers[] = { 1, -2, 6, -1, 3};
        kadanes(numbers);
        
    }
}
