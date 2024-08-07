package karlCodeTraining.D35DP.PartitionEqualSubsetSum416;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1,5,11,5};
        System.out.println(s.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int i = 1; i < sum / 2 + 1; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[nums.length - 1][sum / 2] == sum / 2;
    }
}
