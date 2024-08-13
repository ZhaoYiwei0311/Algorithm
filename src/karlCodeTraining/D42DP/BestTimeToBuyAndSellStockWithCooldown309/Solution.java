package karlCodeTraining.D42DP.BestTimeToBuyAndSellStockWithCooldown309;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,3,0,2};
        System.out.println(solution.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);                // no stock no cool down
            dp[i][1] = dp[i - 1][2] + prices[i];                            // no stock in cool down
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);    // stock
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
