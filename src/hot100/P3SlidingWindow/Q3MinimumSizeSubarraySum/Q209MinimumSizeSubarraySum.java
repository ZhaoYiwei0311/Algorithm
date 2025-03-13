package hot100.P3SlidingWindow.Q3MinimumSizeSubarraySum;

public class Q209MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Q209MinimumSizeSubarraySum so = new Q209MinimumSizeSubarraySum();
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int i = so.minSubArrayLen(target, nums);
        System.out.println(i);
    }

}
