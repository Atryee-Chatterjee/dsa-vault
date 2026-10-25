/*
Problem: Find All Pairs with a Given Sum

Approach:
- Use two nested loops to check every possible pair
- Start the inner loop from i + 1 to avoid using the same element twice
- Check whether the sum of the pair equals the target
- Print each pair that matches the target sum

Complexity:
Time: O(n²)
Space: O(1) auxiliary

Key Idea:
- Check every unique pair in the ArrayList
- Print the pairs whose sum equals the target
- Duplicate values can produce multiple valid pairs
*/
package ArrayLists;

import java.util.*;

public class FindAllPairsWithSum {

    public static void findPairs(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    System.out.println("(" + list.get(i) + ", " + list.get(j) + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(7);
        list.add(-1);
        list.add(5);
        list.add(3);

        int target = 6;

        findPairs(list, target);
    }
}
