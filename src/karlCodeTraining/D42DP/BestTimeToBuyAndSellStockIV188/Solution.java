package karlCodeTraining.D42DP.BestTimeToBuyAndSellStockIV188;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {2,4,1};
        int k = 2;
        System.out.println(solution.maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k * 2 + 1];
        for (int i = 1; i <= k * 2; i++) {
            if (i % 2 == 1) {
                dp[0][i] = -prices[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k * 2; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][k * 2];
    }
}
