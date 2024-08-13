package karlCodeTraining.D41DP.BestTimeToBuyAndSellStock121;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(prices[i] + dp[i - 1][0], dp[i - 1][1]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i][0] + " " + dp[i][1]);
        }
        return dp[prices.length - 1][1];


    }

}
