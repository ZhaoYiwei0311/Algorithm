package karlCodeTraining.D36DP.LastStoneWeightII1049;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = new int[]{31,26,33,21,40};
        System.out.println(solution.lastStoneWeightII(stones));

    }

    // Separate the stones into two parts with the closest sum
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length][target + 1];
        for (int i = 1; i <= target; i++) {
            dp[0][i] = stones[0] <= i ? stones[0] : 0;
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (stones[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        int max = dp[stones.length - 1][target];
        return sum - max - max;
    }
}
