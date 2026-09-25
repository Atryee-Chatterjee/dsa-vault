/*
Problem: Reverse a String using a Stack

Approach:
- Create a character stack
- Push each character of the string into the stack
- Pop characters one by one and append them to the result
- Since Stack follows LIFO, the characters are added in reverse order

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- Push all characters into the stack
- Pop them to get the string in reverse order
*/
package Stacks;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(reverseString(str));
    }
}
