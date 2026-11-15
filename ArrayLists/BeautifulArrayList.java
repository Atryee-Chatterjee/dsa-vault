/*
Problem: Beautiful Array

Approach:
- Initialize the result ArrayList with 1
- Build the beautiful array iteratively from 1 to n
- Create a temporary ArrayList in each iteration
- Add valid even numbers using 2 * e
- Add valid odd numbers using 2 * e - 1
- Replace the previous array with the newly generated array
- Return the final beautiful array

Complexity:
Time: O(n log n)
Space: O(n)

Key Idea:
- Generate even and odd elements separately
- The transformation preserves the beautiful array property
- Include only elements that are less than or equal to n
*/
package ArrayLists;

import java.util.ArrayList;

public class BeautifulArrayList {

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        // Build the beautiful array from 1 to n
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Add even numbers
            for (Integer e : ans) {
                if (2 * e <= n) {
                    temp.add(2 * e);
                }
            }

            // Add odd numbers
            for (Integer e : ans) {
                if (2 * e - 1 <= n) {
                    temp.add(2 * e - 1);
                }
            }
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;

        ArrayList<Integer> result = beautifulArray(n);

        System.out.println(result);
    }
}
