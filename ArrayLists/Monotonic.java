/*
Problem: Check if an ArrayList is Monotonic

Approach:
- Assume the ArrayList is both increasing and decreasing
- Traverse the ArrayList and compare each element with the next element
- If the current element is smaller than the next element, the list cannot be decreasing
- If the current element is greater than the next element, the list cannot be increasing
- Equal elements do not affect either condition
- Return true if the list is either increasing or decreasing

Complexity:
Time: O(n)
Space: O(1)

Key Idea:
- Maintain two boolean flags: increasing and decreasing
- Eliminate a possibility whenever the order is violated
- A monotonic list can be either entirely non-decreasing or entirely non-increasing
*/
package ArrayLists;
import java.util.ArrayList;

public class Monotonic {
    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                decreasing = false;
            }
            if (list.get(i) > list.get(i + 1)) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(isMonotonic(list));
    }
}