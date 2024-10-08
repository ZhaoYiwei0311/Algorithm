package karlCodeTraining.D42DP.BestTimeToBuyAndSellStockWithTransactionFee714;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
