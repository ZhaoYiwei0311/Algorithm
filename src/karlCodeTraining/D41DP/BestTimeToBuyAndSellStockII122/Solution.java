package karlCodeTraining.D41DP.BestTimeToBuyAndSellStockII122;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        // dp[i][0] means the cash when the stock held on the ith day
        // dp[i][1] means the cash when no stock held on the ith day
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
