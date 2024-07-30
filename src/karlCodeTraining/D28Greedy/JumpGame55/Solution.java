package karlCodeTraining.D28Greedy.JumpGame55;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            int curMax = i + nums[i];

            max = Math.max(max, curMax);
            if (max >= nums.length - 1) {
                return true;
            }

        }

        return false;
    }
}
