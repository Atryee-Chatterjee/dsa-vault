/*
Problem: Maximum Balanced String Partitions

Approach:
- Initialize counters for 'L' and 'R' and a variable to store the answer
- Traverse the string character by character
- Increment the corresponding counter for each 'L' or 'R'
- Whenever the count of 'L' becomes equal to the count of 'R', increment the answer
- Return the total number of balanced partitions

Complexity:
Time: O(n)
Space: O(1)
Here, n is the length of the string.

Key Idea:
- A substring is balanced when it contains an equal number of 'L' and 'R'
- Use a greedy approach to count a partition as soon as both counts become equal
- Resetting the counters is not necessary because only the difference between the counts matters
*/
package GreedyAlgorithms;

public class MaximumBalancedStringPartitions {

    public static int balancedPartition(String str, int n) {
        int r = 0;
        int l = 0;
        int ans = 0;

        // Traverse the string
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }

            // Check if the substring is balanced
            if (r == l) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int n = str.length();

        System.out.println(balancedPartition(str, n));
    }
}
