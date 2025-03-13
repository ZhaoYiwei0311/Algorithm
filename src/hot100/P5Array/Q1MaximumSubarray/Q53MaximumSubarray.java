package hot100.P5Array.Q1MaximumSubarray;

public class Q53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int minPrefixSum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            ans = Math.max(prefixSum[i] - minPrefixSum, ans);

            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);

        }

        return ans;

    }

    public static void main(String[] args) {
        Q53MaximumSubarray so = new Q53MaximumSubarray();
        int[] nums = new int[]{-1};
        int i = so.maxSubArray(nums);
        System.out.println(i);
    }
}
