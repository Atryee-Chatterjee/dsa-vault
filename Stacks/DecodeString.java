/*
Problem: Decode a String

Approach:
- Use two stacks: one for repeat counts and one for previous strings
- Build the number when digits are encountered
- When '[' is found, store the current string and repeat count in the stacks
- Reset current string and number for the new substring
- When ']' is found, pop the repeat count and previous string
- Repeat the current string and append it to the previous string
- Add normal characters directly to the current string

Complexity:
Time: O(n * k), where k is the maximum repetition
Space: O(n)

Key Idea:
- Stacks store the previous state while processing nested brackets
- Each ']' completes the current encoded substring
- Example: "3[a2[c]]" becomes "accaccacc"
*/
package Stacks;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String str) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int num = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // Store current string and number
            else if (ch == '[') {
                numStack.push(num);
                stringStack.push(current);

                num = 0;
                current = "";
            }

            // Repeat the current string
            else if (ch == ']') {
                int repeat = numStack.pop();
                String previous = stringStack.pop();

                String temp = "";

                for (int j = 0; j < repeat; j++) {
                    temp += current;
                }
                current = previous + temp;
            }

            // Add normal characters
            else {
                current += ch;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        String str = "3[a2[c]]";

        System.out.println("Decoded String = " + decodeString(str));
    }
}