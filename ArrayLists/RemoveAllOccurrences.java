/*
Problem: Remove All Occurrences of a Target Element

Approach:
- Traverse the ArrayList from the last index to the first
- Check whether the current element matches the target
- Remove the element if it matches the target
- Traverse backwards to avoid skipping elements after removal

Complexity:
Time: O(n²)
Space: O(1) auxiliary

Key Idea:
- Removing an element shifts the remaining elements to the left
- Traversing backwards prevents index-related issues when removing duplicates
*/
package ArrayLists;

import java.util.ArrayList;

public class RemoveAllOccurrences {

    public static void removeOccurrences(ArrayList<Integer> list, int target) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == target) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(5);
        list.add(9);

        int target = 5;

        removeOccurrences(list, target);

        System.out.println(list);
    }
}
