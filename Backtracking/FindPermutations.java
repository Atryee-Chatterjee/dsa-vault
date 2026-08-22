/*
Problem: Find All Permutations of a String

Approach:
- Use recursion and backtracking to generate all possible permutations
- Pick one character at a time and add it to the answer
- Remove the selected character from the remaining string
- Recursively generate permutations using the remaining characters
- Base case:
  → When the string becomes empty, print the permutation

Complexity:
Time: O(n × n!)
Space: O(n) due to recursion stack

Key Idea:
- Every character gets a chance to be placed at the current position
- Recursively build the permutation by choosing different characters
- For a string of length n, total permutations = n!
*/
package Backtracking;

public class FindPermutations {
    public static void findPermutations(String str, String ans) {
        // Base Case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursion - O(n * n!)
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // remove curr char - "abcde" -> "ab" + "de" -> "abde"
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");

    }
}
