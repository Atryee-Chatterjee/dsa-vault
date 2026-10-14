/*
Problem: Generate Binary Numbers from 1 to N

Approach:
- Use a queue to generate binary numbers in increasing order
- Add "1" to the queue as the starting number
- Remove the front element and print it
- Append "0" and "1" to the current number and add them to the queue
- Repeat until N binary numbers are generated

Complexity:
Time: O(n log n)
Space: O(n log n)

Key Idea:
- Each number generates two new binary numbers by appending "0" and "1"
- The queue processes numbers in FIFO order
- This generates binary numbers in increasing order without converting decimal numbers to binary
*/
package Queues;

import java.util.*;

public class GenerateBinaryNumbers {

    public static void generateBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 1; i <= n; i++) {
            String current = q.remove();

            System.out.print(current + " ");

            q.add(current + "0");
            q.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        generateBinaryNumbers(n);
    }
}
