/*
Problem: Check if a String is a Palindrome

Approach:
- A palindrome is a string that reads the same forward and backward

- Traverse the string up to half of its length:
  → Compare characters from both ends:
      - Left side → str.charAt(i)
      - Right side → str.charAt(n - 1 - i)
  → If any pair does not match:
      - Return false immediately

- If all characters match:
  → Return true

Complexity:
Time: O(n)  (n = length of string)
Space: O(1)

Notes:
- Only need to check half of the string
- Efficient since it avoids extra space (no reverse string used)
- Case-sensitive (e.g., "Madam" ≠ "madam")
- Can be extended to ignore spaces, punctuation, or case if needed
*/
package Strings;

import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Word: ");
        String str = sc.next();
        System.out.println(isPalindrome(str));
        sc.close();
    }
}
