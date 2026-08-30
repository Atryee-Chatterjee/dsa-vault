/*
Keypad Combinations — Backtracking

Approach:
- Map each digit from 2–9 to its corresponding letters.
- Start from the first digit and recursively choose each possible letter.
- Build the combination using StringBuilder.
- Move to the next digit using pos + 1.
- When all digits are processed, print the generated combination.
- Backtracking explores every possible letter choice for each digit.

Example:
- Input: "23"
- Output: ad, ae, af, bd, be, bf, cd, ce, cf

Time Complexity: O(4^N)
Space Complexity: O(N) for the recursion depth.
*/
package Backtracking;

public class KeypadCombinations {
    final static char[][] keypadMapping = {
            {}, {},
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    public static void generateCombinations(int pos, int len, StringBuilder sb, String digit) {
        // Base case: : all digits are processed
        if (pos == len) {
            System.out.print(sb.toString() + ", ");
            return;
        } else {
            // Get letters mapped to the current digit
            char[] letters = keypadMapping[Character.getNumericValue(digit.charAt(pos))];

            // Try each possible letter recursively
            for (int i = 0; i < letters.length; i++) {
                // Choose a letter and move to the next digit
                generateCombinations(pos + 1, len, new StringBuilder(sb).append(letters[i]), digit);
            }
        }
    }

    public static void printKeypadCombinations(String digit) {
        int len = digit.length();
        // Handle empty input
        if (len == 0) {
            System.out.print("");
            return;
        }
        generateCombinations(0, len, new StringBuilder(), digit);
    }

    public static void main(String[] args) {
        printKeypadCombinations("23");
    }
}
