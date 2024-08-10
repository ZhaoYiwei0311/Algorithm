package karlCodeTraining.D37DP.CoinChangeII518;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(s.change(amount, coins));
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        // initialize first column
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        // initialize first row
        for (int i = coins[0]; i <= amount; i++) {
            dp[0][i] += dp[0][i - coins[0]];
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[coins.length - 1][amount];

    }
}
