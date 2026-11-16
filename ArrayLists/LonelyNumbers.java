/*
Problem: Find Lonely Numbers in an ArrayList

Approach:
- Sort the ArrayList in ascending order
- Create a new ArrayList to store lonely numbers
- Check each middle element against its previous and next elements
- Add the element if neither adjacent value (x - 1 or x + 1) exists
- Handle the first and last elements separately
- Handle the case where the ArrayList contains only one element
- Return the list of lonely numbers

Complexity:
Time: O(n log n)
Space: O(n)
Here, n is the number of elements in the ArrayList.

Key Idea:
- Sorting makes it easier to check neighboring values
- A number is lonely if it appears only once and neither x - 1 nor x + 1 exists
- Check boundary elements separately to avoid index errors
*/
package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumbers {

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {

        // Sort the ArrayList
        Collections.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();

        // Check middle elements
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i)
                    && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        // Handle single element
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        // Check first and last elements
        if (nums.size() > 1) {

            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }

            if (nums.get(nums.size() - 2) + 1
                    < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        ArrayList<Integer> result = findLonely(nums);

        System.out.println(result);
    }
}
