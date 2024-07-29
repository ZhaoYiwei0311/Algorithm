package karlCodeTraining.D27Greedy.MaximumSubarray53;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if ((nums[i] >= 0 && curSum <= 0) || (nums[i] < 0 && curSum < 0)) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            max = Math.max(max, curSum);

        }
        return max;
    }
}
