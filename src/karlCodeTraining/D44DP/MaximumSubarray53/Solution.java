package karlCodeTraining.D44DP.MaximumSubarray53;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (dp[i - 1] + nums[i - 1] < nums[i - 1]) {
                dp[i] = nums[i - 1];
                max = Math.max(nums[i - 1], max);
                continue;
            }
            dp[i] = dp[i - 1] + nums[i - 1];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
