/*
Problem: Contains Duplicate

Approach:
- Use a brute-force method with two loops
- Compare each element with all elements after it
- If any pair of elements is equal → return true
- If no duplicates are found → return false

Complexity:
Time: O(n^2)
Space: O(1)

Notes:
- Simple but inefficient for large arrays
- Does not require extra space
- Can be optimized using HashSet to O(n) time
*/
public class ContainsDuplicate {
    public static boolean containsDuplicate(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println(containsDuplicate(nums));
    }
}
