/*
Problem: Check if Parentheses are Valid

Approach:
- Use a stack to store opening brackets
- Traverse the string character by character
- Push opening brackets onto the stack
- For a closing bracket, check whether the stack is empty
- Compare the closing bracket with the top opening bracket
- Pop the matching opening bracket
- Return false if brackets do not match
- At the end, the stack must be empty for a valid string

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack follows LIFO, so the most recently opened bracket must be closed first
- Every closing bracket must match the top element of the stack
*/
package Stacks;

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // Opening
            if (curr == '(' || curr == '{' || curr == '[') {
                s.push(curr);
            } else {
                // Closing
                if (s.isEmpty()) {
                    return false;
                }
                // Pair check
                if ((s.peek() == '(' && curr == ')') // ()
                        || (s.peek() == '{' && curr == '}') // {}
                        || (s.peek() == '[' && curr == ']')) { // []
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
    }
}
