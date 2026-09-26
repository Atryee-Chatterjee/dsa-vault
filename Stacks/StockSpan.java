/*
Problem: Calculate Stock Span

Approach:
- Use a stack to store indices of previous greater stock prices
- Set the span of the first day to 1
- For each stock price, remove indices whose prices are smaller than the current price
- If the stack is empty, the span is i + 1
- Otherwise, calculate the span using the nearest previous greater price
- Push the current index into the stack

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- The stack maintains indices of useful previous greater prices
- Each index is pushed and popped at most once
- The nearest greater price determines the stock span
*/
package Stacks;

import java.util.Stack;

public class StockSpan {
    public static void calculateSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1; // Span for first day
        s.push(0); // Store index

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            // Remove smaller prices
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            
            // Calculate current span
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i); // Store current index
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];

        calculateSpan(stocks, span);
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
