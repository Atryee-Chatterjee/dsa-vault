/*
Problem: Find the Longest Valid Parentheses Substring

Approach:
- Use a stack to store indices of opening brackets
- Push -1 as the base index for calculating substring length
- For '(' push its index onto the stack
- For ')' pop the matching opening bracket
- If the stack becomes empty, push the current index as the new base
- Otherwise, calculate the valid substring length using the current index and stack top
- Keep track of the maximum valid length

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack stores indices needed to calculate valid parentheses lengths
- The top of the stack represents the index before the current valid substring
- The -1 base index helps calculate lengths starting from index 0
*/
package Stacks;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String str) {
        Stack<Integer> s = new Stack<>();

        // Base index for calculating valid substring length
        s.push(-1);

        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                // Store the idx of opening bracket
                s.push(i);
            } else {
                // Remove the matching opening bracket
                s.pop();

                if (s.isEmpty()) {
                    // Current idx becomes the new base
                    s.push(i);
                } else {
                    // Calculate length of valid parentheses
                    int length = i - s.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String str = ")()())";

        System.out.println("Longest valid parentheses length = "
                + longestValidParentheses(str));
    }
}