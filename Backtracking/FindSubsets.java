/*
Problem: Find All Subsets of a String

Approach:
- Use recursion and backtracking to generate all possible subsets
- For each character, there are two choices:
  → YES: Include the current character in the subset
  → NO: Exclude the current character from the subset
- Recursively make both choices for every character
- Base case:
  → When all characters are processed, print the subset
  → Print "null" for the empty subset

Complexity:
Time: O(2^n)
Space: O(n) due to recursion stack

Key Idea:
- Every character has two choices: include or exclude
- For n characters, total subsets = 2^n
*/
package Backtracking;

public class FindSubsets {
    public static void findSubsets(String str, String ans, int i) {
        // Base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // YES - choice
        findSubsets(str, ans + str.charAt(i), i + 1);
        // NO - choice
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }
}
