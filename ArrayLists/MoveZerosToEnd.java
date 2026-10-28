/*
Problem: Move All Zeros to the End of an ArrayList

Approach:
- Use an index to track the position for non-zero elements
- Traverse the ArrayList and move each non-zero element to the front
- Fill the remaining positions with zeros
- Maintain the relative order of non-zero elements

Complexity:
Time: O(n)
Space: O(1) auxiliary

Key Idea:
- Move non-zero elements forward without creating another list
- Fill the remaining positions with zeros
- Preserve the original order of non-zero elements
*/
package ArrayLists;

import java.util.*;

public class MoveZerosToEnd {

    public static void moveZeros(ArrayList<Integer> list) {
        int index = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                list.set(index, list.get(i));
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < list.size()) {
            list.set(index, 0);
            index++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(2);
        list.add(0);
        list.add(4);
        list.add(5);
        list.add(0);
        list.add(3);

        moveZeros(list);

        System.out.println(list);
    }
}
