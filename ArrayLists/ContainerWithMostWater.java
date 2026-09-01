/*
Problem: Container With Most Water

Approach:

* Use an ArrayList where each value represents the height of a vertical line

* Brute Force:
  → Check every possible pair of lines
  → Calculate the height, width, and water stored between them
  → Keep track of the maximum water

* Two Pointer:
  → Start with one pointer at the beginning and one at the end
  → Calculate the water between the two pointers
  → Move the pointer with the smaller height
  → Continue until both pointers meet

Complexity:

Brute Force:
Time: O(n²)
Space: O(1)

Two Pointer:
Time: O(n)
Space: O(1)

Key Idea:

* Water stored = Minimum Height × Width
* In the two-pointer approach, always move the pointer with the smaller height because moving the taller pointer cannot increase the container height
  */

package ArrayLists;

import java.util.ArrayList;

public class ContainerWithMostWater {

    // Brute force approach
    public static int maxWaterBruteForce(ArrayList<Integer> height) {
        int maxWater = 0;
        // Brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht * width;
                maxWater = Math.max(currWater, maxWater);
            }
        }
        return maxWater;
    }

    // Two pointer approach
    public static int maxWaterTwoPointer(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            // Calculate water
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(currWater, maxWater);

            // Update ptr
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxWaterBruteForce(height));
        System.out.println(maxWaterTwoPointer(height));
    }
}
