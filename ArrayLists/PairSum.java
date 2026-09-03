/*
Problem: Pair Sum

Approach:

1. Brute Force:
- Check every possible pair of elements in the ArrayList
- Add the two elements and compare their sum with the target
- Return true if any pair matches the target
- Return false if no valid pair is found

2. Two Pointers:
- Use two pointers, one at the beginning and one at the end
- Compare the sum of the elements at both pointers with the target
- If the sum is smaller than the target, move the left pointer forward
- If the sum is greater than the target, move the right pointer backward
- Return true if a pair with the target sum is found
- Return false if the pointers cross

Complexity:

Brute Force:
Time: O(n²)
Space: O(1)

Two Pointers:
Time: O(n)
Space: O(1)

Key Idea:

- Brute Force checks every possible pair
- Two Pointers reduces the search to a single pass
- Two Pointers requires the ArrayList to be sorted
*/
package ArrayLists;

import java.util.ArrayList;

public class PairSum {
    // Brute Force Approch
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Two Pointers Approch
    public static boolean pairSumTwoPointers(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            // Case 1
            if (list.get(left) + list.get(right) == target) {
                return true;
            }
            // Case 2
            if (list.get(left) + list.get(right) < target) {
                left++;
            } else {
                // case 3
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int target = 5;
        System.out.println(pairSum(list, target));
        System.out.println(pairSumTwoPointers(list, target));
    }
}
