/*
Problem: Maximum Product of Two Elements in an Array

Approach:
- Check every possible pair of elements using two loops
- Calculate (nums[i] - 1) * (nums[j] - 1) for each pair
- Keep track of the maximum product
- Return the maximum product found

Complexity:
Time: O(n²)
Space: O(1)

Key Idea:
- Brute-force approach checks all possible pairs
- Works for the given problem constraints
*/
public class MaximumProductOfTwoElements {

    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };

        int result = maxProduct(nums);

        System.out.println("Maximum product of two elements: " + result);
    }
}