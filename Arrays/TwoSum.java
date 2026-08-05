/*
Problem: Two Sum (Find Indices of Two Numbers with Given Target)

Approach:
- Given an array and a target value:
  → Find two indices such that nums[i] + nums[j] = target

- Use brute-force approach:
  → Traverse array using two nested loops
      - Outer loop picks first element (i)
      - Inner loop picks second element (j = i+1)
  → Check if sum equals target
      - If yes → return indices [i, j]

- If no such pair exists:
  → Return empty array

- Input Handling:
  → Take array size from user
  → Take array elements
  → Take target value

- Output:
  → Print indices if found
  → Else print "No solution found"

Complexity:
Time: O(n^2)
Space: O(1)
*/
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Take array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Take target
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Call function
        int[] result = twoSum(nums, target);

        // Output
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }

        sc.close();
    }
}