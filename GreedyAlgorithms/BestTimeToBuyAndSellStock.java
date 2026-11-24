/*
Problem: Best Time to Buy and Sell Stock

Approach:
- Initialize the buying price with the first day's stock price
- Initialize maximum profit as 0
- Traverse the prices array from the second day
- If the current price is lower than the buying price, update the buying price
- Otherwise, calculate the profit by subtracting the buying price from the current price
- Update the maximum profit if a higher profit is found
- Return the maximum profit

Complexity:
Time: O(n)
Space: O(1)
Here, n is the number of days.

Key Idea:
- Buy the stock at the lowest price seen so far
- Sell it at a later day when the profit is maximum
- Traverse the array only once to find the maximum possible profit
- If no profitable transaction is possible, return 0
*/
package GreedyAlgorithms;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int prices[], int n) {
        int buy = prices[0];
        int maxProfit = 0;

        // Find the minimum buying price and maximum profit
        for (int i = 1; i < n; i++) {

            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > maxProfit) {
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int n = prices.length;

        System.out.println("Maximum Profit: " + maxProfit(prices, n));
    }
}
