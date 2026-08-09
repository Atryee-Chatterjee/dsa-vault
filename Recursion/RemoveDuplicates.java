/*
Problem: Remove duplicate characters from a string using recursion

Approach:
- Use a boolean array (map) of size 26 to track visited characters
- Traverse the string recursively using index (idx)

Steps:
1. Base case: If idx reaches end of string, print result
2. Get current character
3. If already visited → skip it and move ahead
4. If not visited:
   - Mark it as visited
   - Add to StringBuilder
   - Continue recursion

Complexity:
- Time: O(n)
- Space: O(n) (recursion + StringBuilder)

Key Idea:
- Track duplicates using boolean array
- Build result string during recursion
*/
package Recursion;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map) {
        // base case
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);

        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String str = sc.next();

        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        sc.close();
    }
}
