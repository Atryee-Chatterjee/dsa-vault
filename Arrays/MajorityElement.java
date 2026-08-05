/*
Problem: Find Majority Element in an Array

Approach:
- For each element, count its occurrences in the array
- If any element appears more than n/2 times, return it
- If no such element exists, return -1

Complexity:
Time: O(n^2)
Space: O(1)

Notes:
- Uses brute-force approach
- Simple but not efficient for large inputs
*/
import java.util.Scanner;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // Check majority condition
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // No majority element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Validate size
        if (n <= 0) {
            System.out.println("Invalid array size!");
            sc.close();
            return;
        }

        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = majorityElement(nums);

        // Output result
        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No Majority Element found");
        }

        sc.close();
    }
}