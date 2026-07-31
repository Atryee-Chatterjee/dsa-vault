/*
Problem: Trapping Rain Water

Approach:
- For each index, water depends on the minimum of:
  → left maximum height
  → right maximum height
- First, build two arrays:
  → leftMaxBoundary[i] = max height from left till i
  → rightMaxBoundary[i] = max height from right till i
- For each index:
  → waterLevel = min(leftMax, rightMax)
  → trapped water = waterLevel - height[i]
- Add all trapped water values

Complexity: 
Time: O(n)
Space: O(n)

Notes:
- Precomputing left and right max arrays avoids repeated calculations
- Works efficiently for all cases
- Key idea: water is trapped only if there are taller bars on both sides
- Min numbers of bars >=2
- Asc/Dsc no water is trapped
*/
public class TrappedRainWater {
    public static void trappedRainWater(int height[]) {
        int n = height.length;

        // Calculate Left max boundary - array
        int leftMaxBoundary[] = new int[n];
        leftMaxBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxBoundary[i] = Math.max(leftMaxBoundary[i - 1] , height[i]);
        }

        // Calculate Right max boundary - array
        int rightMaxBoundary[] = new int[n];
        rightMaxBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxBoundary[i] = Math.max(rightMaxBoundary[i + 1] , height[i]);
        }
        
        int trappedWater = 0;
        for(int i=0; i<n; i++){
            // Calculate water level
            int waterLevel = Math.min(rightMaxBoundary[i], leftMaxBoundary[i]);
            trappedWater += waterLevel - height[i]; 
        }
        System.out.println("total trapped water " + trappedWater);

    }

    public static void main(String[] args) {
        int height[] = { 0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1 };
        trappedRainWater(height);
    }
}
