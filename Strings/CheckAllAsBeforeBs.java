/*
Problem: Check if All 'a's Appear Before All 'b's

Approach:
- Traverse the string starting from the second character
- Check if the current character is 'a' and the previous character is 'b'
- If this pattern "ba" is found, return false
- If no invalid pattern is found, return true

Complexity:
Time: O(n)
Space: O(1)
Here, n is the length of the string.

Key Idea:
- A valid string must contain all 'a's before all 'b's
- The pattern "ba" indicates that an 'a' appears after a 'b'
- Checking adjacent characters is sufficient to detect an invalid ordering
*/
package Strings;

import java.util.Scanner;

public class CheckAllAsBeforeBs {

    public static boolean checkString(String s) {
        // Check for invalid pattern "ba"
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && s.charAt(i - 1) == 'b') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaabbb";

        System.out.println(checkString(s));
    }
}