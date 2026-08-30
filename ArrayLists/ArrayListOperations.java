/*
ArrayList Operations
Demonstrates common operations on an ArrayList such as printing elements,
reversing, finding the maximum value, swapping elements, and sorting.
 */
package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add Operation - O(1)
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(8);
        list.add(2);

        // 1. Print ArrayList
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }

        // 2. Print reverse - O(n)
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + ", ");
        }

        // 3. Find Maximum - O(n)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);

        // 4. Swap Numbers
        int idx1 = 1, idx2 = 3;
        System.out.println(list + ", ");
        swap(list, idx1, idx2);
        System.out.println(list + ", ");

        // 5. Sort an ArrayList
        System.out.println(list); // original arraylist

        Collections.sort(list); // Ascending order by default
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // Descending order
        System.out.println(list);

    }
}
