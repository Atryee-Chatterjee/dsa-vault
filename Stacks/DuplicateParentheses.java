/*
Problem: Check for Duplicate Parentheses

Approach:
- Use a stack to store opening brackets, operators, and operands
- Traverse the expression character by character
- When ')' is found, pop elements until '(' is reached
- Count the elements between the pair of parentheses
- If no element exists between them, the parentheses are duplicate
- Return false if no duplicate parentheses are found

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- Duplicate parentheses contain no operator or operand between '(' and ')'
- If count is 0, the current pair is unnecessary and therefore duplicate
*/
package Stacks;

import java.util.*;

public class DuplicateParentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Closing - ')'
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') { //Find pair
                    count++;
                }
                if (count < 1) {
                    return true; // Duplicate
                }
            } else { // Opening - oparator, oparand, opening '('
                s.push(ch);
            }
        }
        return false; // No duplicate
    }

    public static void main(String[] args) {
        String str = "((a+b))"; // true
        String str2 = "((a+b) + (c+d))"; // false

        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str2));
    }
}
