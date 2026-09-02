/*
Problem: Pair Sum

Approach:

- Check every possible pair of elements in the ArrayList
- Add the two elements and compare their sum with the target
- Return true if any pair matches the target
- Return false if no valid pair is found

Complexity:

Time: O(n²)
Space: O(1)

Key Idea:

- Use two loops to generate all possible pairs
- Each pair is checked only once
*/
package ArrayLists;
import java.util.ArrayList;

public class PairSum {
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

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int target = 5;
        System.out.println(pairSum(list, target));

    }
}
