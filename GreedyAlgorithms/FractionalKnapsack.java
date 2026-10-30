/*
Problem: Fractional Knapsack

Approach:
- Calculate the value-to-weight ratio for each item
- Store each item's index and ratio in a 2D array
- Sort items by their value-to-weight ratio in ascending order
- Traverse the sorted array in reverse to select items with higher ratios first
- Include the entire item if its weight fits within the remaining capacity
- Otherwise, include the fraction that fits and calculate its value
- Stop when the knapsack capacity becomes zero

Complexity:
Time: O(n log n)
Space: O(n)

Key Idea:
- Greedily select items with the highest value-to-weight ratio
- Unlike 0/1 Knapsack, fractional items are allowed
- Prioritizing higher ratios maximizes the total value
*/
package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void getMaxValue(int values[], int weights[], int w) {
        double ratio[][] = new double[values.length][2];
        // 0th col => idx, 1st col => ratio

        for (int i = 0; i < values.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = values[i] / (double) weights[i];
        }

        // Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        double finalVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {//dsce
            int idx = (int) ratio[i][0];
            if (capacity >= weights[idx]) { // Include full item
                finalVal += values[idx];
                capacity -= weights[idx];
            } else {
                // Include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value = " + finalVal);
    }

    public static void main(String[] args) {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        getMaxValue(values, weights, capacity);
    }
}
