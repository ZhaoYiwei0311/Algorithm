package karlCodeTraining.D38DP.CoinChange322;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 3;
        int[] coins = {2};
        System.out.println(solution.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 10001;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];

    }
}
