/*
Problem: Count Substrings Starting and Ending with the Same Character

Approach:
- Use recursion to consider all possible substrings
- For each range, recursively count:
  → Substrings excluding the first character
  → Substrings excluding the last character
  → Subtract overlapping substrings counted twice
- If the first and last characters are the same, increment the count
- Base cases:
  → n == 1 → one single-character substring
  → n <= 0 → no substring

Complexity:
Time: O(2^n)
Space: O(n) due to recursion stack

Key Idea:
- Every substring is represented by its starting index i and ending index j
- Recursively shrink the range and count valid substrings
- A substring is valid when its first and last characters are the same
*/
package Recursion;

public class CountSameCharSubstrings {
    public static int countSubstrings(String str, int n, int i, int j) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int res = countSubstrings(str, n - 1, i + 1, j) +
                countSubstrings(str, n - 1, i, j - 1)
                - countSubstrings(str, n - 2, i + 1, j - 1);

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcde";
        int n = str.length();
        System.out.println(countSubstrings(str, n, 0, n - 1));
    }
}
