/*
Problem: Search in Rotated Sorted Array

Approach:
- Use modified Binary Search
- At each step, find mid index
- Check which half is sorted:
  → If left half is sorted:
      - Check if target lies in this range
      - If yes → search left side
      - Else → search right side
  → Else (right half is sorted):
      - Check if target lies in this range
      - If yes → search right side
      - Else → search left side
- Repeat until target is found or search space is exhausted

Complexity:
Time: O(log n)
Space: O(1)

Notes:
- Array is rotated but one half is always sorted
- Key idea: use sorted half to eliminate half of the search space
- Works only when all elements are distinct
*/
public class SearchInRotatedSortedArray {
    public static int searchInRotatedSortedArray(int nums[], int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(searchInRotatedSortedArray(nums, 6));
    }
}
