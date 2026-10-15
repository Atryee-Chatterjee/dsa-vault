/*
Problem: Find the First Non-Repeating Character in a Stream

Approach:
- Use a frequency array to count occurrences of each character
- Use a queue to maintain characters in the order they appear
- Traverse the string character by character
- Add each character to the queue and update its frequency
- Remove characters from the front whose frequency is greater than 1
- If the queue is empty, print -1
- Otherwise, print the character at the front of the queue

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The queue maintains the order of characters
- The frequency array identifies repeating characters
- The front of the queue always represents the first non-repeating character
*/
package Queues;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void firstNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            q.add(ch);
            freq[ch - 'a']++;

            // Remove repeating characters from the front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // Print the first non-repeating character
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabc";

        firstNonRepeating(str);
    }
}
