/*
Problem: Daily Temperatures

Approach:
- Use a stack to store indices of future temperatures
- Traverse the array from right to left
- Remove indices whose temperatures are less than or equal to the current temperature
- If the stack is not empty, calculate the waiting days using the top index
- If the stack is empty, no warmer temperature exists, so the result remains 0
- Push the current index onto the stack

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack stores indices of potentially warmer future temperatures
- Each index is pushed and popped at most once
- The difference between indices gives the number of days to wait
*/
package Stacks;

import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove temperatures that are not warmer
            while (!s.isEmpty() &&
                    temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            // Calculate the waiting days
            if (!s.isEmpty()) {
                result[i] = s.peek() - i;
            }

            s.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(
                Arrays.toString(dailyTemperatures(temperatures)));
    }
}
