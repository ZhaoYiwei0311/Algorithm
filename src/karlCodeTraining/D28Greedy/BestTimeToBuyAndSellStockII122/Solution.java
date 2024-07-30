package karlCodeTraining.D28Greedy.BestTimeToBuyAndSellStockII122;

public class Solution {

    // Collect positive values of profit array
    // price:   7   1   5   10  3   6   4
    // profit:      -6  4   5   -7  3   -2
    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            profits[i] = prices[i] - prices[i - 1];
        }
        int sum = 0;
        for (int profit : profits) {
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }
}
