/*
Problem: Lexicographically Smallest String of Length N and Sum K

Approach:
- Initialize a character array of length n with all characters as 'a'
- Subtract n from k because each 'a' contributes 1 to the total sum
- Distribute the remaining value from right to left
- If the remaining value is at least 25, replace the current character with 'z' and subtract 25
- Otherwise, increase the current character by the remaining value
- Convert the character array into a string and return it

Complexity:
Time: O(n)
Space: O(n)
Here, n is the length of the string.

Key Idea:
- Assign 'a' to every position initially to get the lexicographically smallest string
- Distribute the remaining sum from right to left to keep earlier characters as small as possible
- Each character can contribute at most 25 additional value (from 'a' to 'z')
*/
package GreedyAlgorithms;

public class LexicographicallySmallestString {

    public static String lexoSmall(int n, int k) {
        char arr[] = new char[n];

        // Initialize all characters with 'a'
        for (int i = 0; i < n; i++) {
            arr[i] = 'a';
        }

        // Remaining value after assigning 'a' to each position
        k = k - n;

        // Distribute remaining value from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (k >= 25) {
                arr[i] = 'z';
                k -= 25;
            } else if (k > 0) {
                arr[i] = (char) (arr[i] + k);
                k = 0;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 42;

        System.out.println(lexoSmall(n, k));
    }
}
