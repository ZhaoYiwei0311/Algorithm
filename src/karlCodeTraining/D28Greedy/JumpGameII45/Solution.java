package karlCodeTraining.D28Greedy.JumpGameII45;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        Solution s = new Solution();
        System.out.println(s.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int max = 0;
        int prevMax = 0;
        for (int i = 0; i <= prevMax; i++) {
            int curMax = nums[i] + i;
            if (curMax > max) {
                max = curMax;
            }
            if (max >= nums.length - 1) {
                count++;
                return count;
            }
            if (i == prevMax) {
                prevMax = max;
                count++;
            }
        }
        return max;
    }
}
