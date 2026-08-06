/*
Problem: Count Lowercase Vowels in a String

Approach:
- Traverse each character of the string
- Check if the character is a lowercase vowel (a, e, i, o, u)
- Increment count whenever a vowel is found

Complexity:
Time: O(n)
Space: O(1)

Notes:
- Only lowercase vowels are considered
- Uppercase vowels are ignored
*/
package Strings;

import java.util.Scanner;

class CountLowercaseVowels {
    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(countVowels(str));
        sc.close();

    }

}