package karlCodeTraining.D39DP.HouseRobberII213;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    // Divide by type
    private int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start + 1], dp[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[dp.length - 1];
    }
}
