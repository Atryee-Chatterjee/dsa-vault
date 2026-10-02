/*
Problem: Remove Adjacent Duplicates from a String

Approach:
- Use a stack to process each character
- If the current character matches the stack's top, pop it
- Otherwise, push the current character into the stack
- Build the result by popping all remaining characters
- Reverse the result because the stack is popped from top to bottom

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack keeps track of the characters that remain
- Matching adjacent characters cancel each other out
- This also handles new adjacent duplicates created after removal
*/
package Stacks;

import java.util.*;

public class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If top element is same as current character, remove it
            if (!s.isEmpty() && s.peek() == ch) {
                s.pop();
            } else {
                // Otherwise, add current character to stack
                s.push(ch);
            }
        }

        // Build the final string from the stack
        StringBuilder result = new StringBuilder();

        while (!s.isEmpty()) {
            result.append(s.pop());
        }

        // Stack is popped from top to bottom, so reverse the result
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";

        System.out.println("Original String: " + str);
        System.out.println("After Removing Duplicates: " + removeDuplicates(str));
    }
}