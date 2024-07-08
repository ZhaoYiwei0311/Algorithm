package karlCodeTraining.D2Array.MinimunSizeSubarraySum209;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr =  {2,3,1,2,4,3};
        int target = 7;
        System.out.println(s.minSubArrayLen(target, arr));
    }

    /**
     * The main point is to define invariant of each loop
     * In this question, it should be the end pointer
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int ans = nums.length + 2;
        int sum = 0;

        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                ans = Math.min(ans, right - left + 1);
                left++;
            }
        }
        return ans == nums.length + 2 ? 0 : ans;
    }
}
