/*
Problem: Trapping Rain Water

Approach:
- Use Two Pointer technique
- Initialize two pointers:
  → left (l) at start
  → right (r) at end
- Maintain two variables:
  → lMax = maximum height from left
  → rMax = maximum height from right
- At each step:
  → Compare lMax and rMax
  → If lMax < rMax:
      - Move left pointer (l++)
      - Update lMax
      - Water trapped = lMax - height[l]
  → Else:
      - Move right pointer (r--)
      - Update rMax
      - Water trapped = rMax - height[r]
- Repeat until l < r

Complexity:
Time: O(n)
Space: O(1)

Notes:
- Water trapped depends on min(lMax, rMax)
- Always move the pointer with smaller max height
- This avoids using extra space (unlike prefix/suffix arrays)
- Optimal solution for this problem
*/
public class TrappingRainWaterTwoPointer {
    public static int trapRainWaterTwoPointer(int height[]) {

        // Edge case: if array is empty, no water can be trapped
        if (height == null || height.length == 0)
            return 0;

        int n = height.length;

        int res = 0; // stores total trapped water
        int l = 0, r = n - 1; // two pointers: left and right

        // lMax = max height seen from left
        // rMax = max height seen from right
        int lMax = height[l], rMax = height[r];

        // Traverse until both pointers meet
        while (l < r) {

            // Always move the side with smaller max height
            // because water level depends on the smaller boundary
            if (lMax < rMax) {

                l++; // move left pointer

                // update left max height
                lMax = Math.max(lMax, height[l]);

                // water trapped at current index
                res += lMax - height[l];

            } else {

                r--; // move right pointer

                // update right max height
                rMax = Math.max(rMax, height[r]);

                // water trapped at current index
                res += rMax - height[r];
            }
        }

        // return total trapped water
        return res;
    }

    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        // Expected output: 6
        System.out.println(trapRainWaterTwoPointer(height));
    }
}