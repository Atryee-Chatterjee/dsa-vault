/*
Problem: Shortest Path from Direction String

Approach:
- Given a string of directions (N, S, E, W)
  → Each character represents movement in 2D plane

- Initialize coordinates:
  → x = 0, y = 0 (starting point)

- Traverse the string:
  → For each character:
      - 'N' → move up (y++)
      - 'S' → move down (y--)
      - 'E' → move right (x++)
      - 'W' → move left (x--)

- After processing all directions:
  → Final position is (x, y)

- Compute shortest distance from origin using distance formula:
  → distance = √(x² + y²)

- Return the result as float

Complexity:
Time: O(n)  (n = length of string)
Space: O(1)

Notes:
- Uses Euclidean distance formula
- Does NOT return path, only shortest distance
- Ignores intermediate path, only final position matters
- Can be extended to return coordinates as well
*/
package Strings;

public class ShortestPath {
    public static float getShortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);

            // South
            if (dir == 'S') {
                y--;
            }
            // North
            else if (dir == 'N') {
                y++;
            }
            // West
            else if (dir == 'W') {
                x--;
            }
            // East
            else {
                x++;
            }
        }
        int x2 = x * x;
        int y2 = y * y;

        return (float) Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(getShortestPath(str));
    }

}
