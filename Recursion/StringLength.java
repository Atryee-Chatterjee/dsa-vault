/*
Problem: Find the Length of a String Using Recursion

Approach:
- Remove the first character of the string using substring(1)
- Recursively find the length of the remaining string
- Add 1 for the removed character
- Base case: when the string becomes empty, return 0

Complexity:
Time: O(n²) due to substring() creating new strings
Space: O(n) due to recursion stack

Key Idea:
- Each recursive call removes one character
- The total count of recursive calls gives the string length
*/
package Recursion;

public class StringLength {
    public static int length(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return length(str.substring(1)) + 1;
    }

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(length(str));
    }
}
