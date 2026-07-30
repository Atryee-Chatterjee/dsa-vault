/*
Problem: Buy and Sell Stocks (Maximum Profit - Single Transaction)

Approach:
- Traverse the array once
- Keep track of the minimum buying price so far
- For each day:
  → If current price > buyPrice → calculate profit
  → Update maxProfit if this profit is higher
  → Else update buyPrice (better day to buy)
- Goal: Buy at lowest price and sell at highest price after that

Complexity:
Time: O(n)
Space: O(1)

Notes:
- Only one transaction allowed (buy once, sell once)
- Ensures buying happens before selling
- Greedy approach for optimal profit
*/
public class BuyAndSellStocks {
    public static void buyAndSellStocks(int prices[]){
        int maxProfit =0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            if(buyPrice < prices[i]){ // Profit
                int profit = prices[i] - buyPrice; // Today's profit
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = prices[i];
            }
        }
        System.out.println("max prfit = " + maxProfit);
    }
    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        buyAndSellStocks(prices);
    }
}
