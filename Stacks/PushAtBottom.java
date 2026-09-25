/*
Problem: Push an Element at the Bottom of a Stack

Approach:
- If the stack is empty, push the new element
- Otherwise, pop the top element and recursively call the method
- Once the bottom is reached, push the new element
- Push the removed elements back in their original order

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- Recursion temporarily removes all elements from the stack
- The new element is pushed at the bottom
- The removed elements are then restored
*/
package Stacks;
import java.util.*;
public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);

        while (! s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
