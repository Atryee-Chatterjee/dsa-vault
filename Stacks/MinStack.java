/*
Problem: Implement a MinStack

Approach:
- Use two stacks: s to store all elements and minStack to track minimum elements
- push(): Add the element to s and push it to minStack if it is less than or equal to the current minimum
- pop(): Remove the top element from s and remove it from minStack if it matches the current minimum
- top(): Return the top element without removing it
- getMin(): Return the minimum element in O(1) time

Complexity:
push(): Time O(1), Space O(1)
pop(): Time O(1), Space O(1)
top(): Time O(1), Space O(1)
getMin(): Time O(1), Space O(1)

Key Idea:
- minStack keeps track of the minimum elements
- The top of minStack always represents the current minimum
- Using <= when pushing handles duplicate minimum values correctly
*/
package Stacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    Stack<Integer> minStack;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        s.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            return;
        }

        int removed = s.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(1);

        System.out.println("Minimum: " + stack.getMin());

        stack.pop();

        System.out.println("Top: " + stack.top());
        System.out.println("Minimum: " + stack.getMin());
    }
}
