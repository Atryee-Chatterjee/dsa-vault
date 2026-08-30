/*
ArrayList Basics
Demonstrates common ArrayList operations such as adding, inserting, accessing,
removing, updating, checking size, and searching for elements.
 */
package ArrayLists;

import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add Operation - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // ArrayList size/length
        System.out.println(list.size());

        // Insert at index - O(n)
        list.add(1, 9);

        System.out.println(list);

        // Get Operation - O(1)
        int element = list.get(2);
        System.out.println(element);

        // Remove Operation - O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at index - O(1)
        list.set(2, 10);
        System.out.println(list);

        // Contains element - O(n)
        System.out.println(list.contains(4));
        System.out.println(list.contains(11));

    }
}
