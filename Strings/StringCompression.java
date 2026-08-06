/*
Problem: String Compression

Approach:
- Traverse the string and group consecutive identical characters
- Count how many times each character repeats
- Append the character to the result
- If count > 1, append the count after the character

Example:
Input: "aaaabbbcc"
Output: "a4b3c2"

Complexity:
Time: O(n)
Space: O(n) (for result storage)

Notes:
- Uses StringBuilder for efficient string manipulation
- Single characters are added without a count
*/
package Strings;

public class StringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));

            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String str = "aaaabbbcc";
        System.out.println(compress(str));
    }
}
