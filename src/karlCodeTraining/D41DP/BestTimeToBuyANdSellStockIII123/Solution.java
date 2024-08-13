package karlCodeTraining.D41DP.BestTimeToBuyANdSellStockIII123;

public class Solution {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; // no buy or sell
        dp[0][1] = -prices[0]; // first buy or hold
        dp[0][2] = 0; // first sell (but today, sell today)
        dp[0][3] = -prices[0]; // second buy or hold
        dp[0][4] = 0; // second sell (but today, sell today)

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(prices[i] + dp[i - 1][1], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(prices[i] + dp[i - 1][3], dp[i - 1][4]);
        }
        return dp[prices.length - 1][4]; // only need status 4 because we can buy and sell status 2
    }
}
