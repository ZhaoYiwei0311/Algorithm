package karlCodeTraining.D36DP.TargetSum494;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,9,3,8,0,2,4,8,3,9};
        int target = 0;
        System.out.println(solution.findTargetSumWays(nums, target));
    }


    // Positive - Negative = Target
    // Positive + Negative = Sum
    // Positive = (Target + Sum) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target) {
            return 0;
        }

        if ((target + sum) % 2 == 1) {
            return 0;
        }

        int positiveSum = (target + sum) / 2;
        int[][] dp = new int[nums.length][positiveSum + 1];
        dp[0][0] = 1;
        if (positiveSum >= nums[0]) {
            dp[0][nums[0]] = 1;
        }

        int numsZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numsZero++;
            }
            dp[i][0] = (int)Math.pow(2, numsZero);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= positiveSum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // dp[i - 1][j] means not choosing current num
                    // dp[i - 1][j - nums[i]] means choosing current num
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][positiveSum];
    }
}
