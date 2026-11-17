/*
Problem: Most Frequent Number Following Key

Approach:
- Create an integer array to store the frequency of each number
- Traverse the ArrayList up to the second-last element
- Check if the current element is equal to the given key
- If it matches, increment the frequency of the next element
- Traverse the frequency array to find the number with the maximum frequency
- Return the number that occurs most frequently after the key

Complexity:
Time: O(n)
Space: O(1)
Here, n is the number of elements in the ArrayList.
The frequency array has a fixed size of 1000.

Key Idea:
- Count only the elements that immediately follow the given key
- Use an array to track the frequency of each possible target
- The index represents the number minus one
*/
package ArrayLists;

import java.util.ArrayList;

public class MostFrequentNumberFollowingKey {

    public static int mostFrequent(ArrayList<Integer> nums, int key) {

        int[] result = new int[1000];

        // Count numbers that immediately follow the key
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;

        // Find the number with maximum frequency
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(100);
        nums.add(200);
        nums.add(1);
        nums.add(100);

        int key = 1;

        System.out.println(mostFrequent(nums, key));
    }
}
