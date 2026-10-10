/*
Problem: Asteroid Collision

Approach:
- Use a stack to store asteroids that survive collisions
- Traverse the array and check for collisions between a positive asteroid and a negative asteroid
- If the stack's top asteroid is smaller, pop it and continue checking
- If both asteroids have equal sizes, destroy both
- If the stack's top asteroid is larger, destroy the current asteroid
- Push the current asteroid if it survives
- Copy the remaining asteroids into the result array in the correct order

Complexity:
Time: O(n)
Space: O(n)

Key Idea:
- Collisions occur only when a positive asteroid is followed by a negative asteroid
- The larger asteroid survives; equal-sized asteroids destroy each other
- The stack helps process collisions in linear time
*/
package Stacks;

import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!s.isEmpty() && asteroid < 0 && s.peek() > 0) {
                if (s.peek() < -asteroid) {
                    s.pop();
                } else if (s.peek() == -asteroid) {
                    s.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                s.push(asteroid);
            }
        }

        int[] result = new int[s.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};

        System.out.println(
            Arrays.toString(asteroidCollision(asteroids))
        );
    }
}
