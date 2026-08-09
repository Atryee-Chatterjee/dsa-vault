/*
Problem: Print all binary strings of length n without consecutive 1s

Approach:
- Base case: If n == 0, print the string
- Always add '0' and recurse
- Add '1' only if last placed digit is 0 (to avoid consecutive 1s)

Example (n = 3):
Output: 000, 001, 010, 100, 101

Complexity:
- Time: O(2^n)
- Space: O(n)

Key Idea:
- Track last placed digit to enforce constraint
*/
package Recursion;

public class PrintBinaryStrings {
    public static void printBinStrings(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinStrings(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        printBinStrings(3, 0, "");
    }
}
