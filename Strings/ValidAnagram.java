/*
Problem: Check if Two Strings are Anagrams

Approach:
- Convert both strings to lowercase (for case-insensitive comparison)
- Check if lengths are equal:
  → If not equal → not anagrams
- Convert both strings into character arrays
- Sort both arrays
- Compare sorted arrays:
  → If equal → strings are anagrams
  → Else → not anagrams

Complexity:
Time: O(n log n) (due to sorting)
Space: O(n)

Notes:
- Uses Arrays.sort() and Arrays.equals()
- Ignores case differences
- Does not handle spaces or special characters
*/
package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {
    public static void isAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // Check if the lengths are the same
        if(str1.length() == str2.length()){
            // convert strings into char array
            char[]str1charArray=str1.toCharArray();
            char[]str2charArray=str2.toCharArray();

            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // if the sorted char arrays are sameor identical then the strings areanagram
            boolean result = Arrays.equals(str1charArray, str2charArray);

            if(result == true){
                System.out.println(str1+" and "+str2+" are anagrams of eachother.");
            }else{
                System.out.println(str1+" and "+str2+" are not anagrams ofeach other.");
            }
        }else{
            // case when lengths are not equal
            System.out.println(str1+" and "+str2+" are not anagrams of eachother.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string:");
        String str1 = sc.next();

        System.out.print("Enter second string:");
        String str2 = sc.next();

        sc.close();

        isAnagram(str1, str2);


    }
}
