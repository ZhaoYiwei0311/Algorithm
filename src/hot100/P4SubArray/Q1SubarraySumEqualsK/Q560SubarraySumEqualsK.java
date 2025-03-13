package hot100.P4SubArray.Q1SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Q560SubarraySumEqualsK {
    /**
     * Prefix sum
     * We can know that sums[j] - sums[i] == k means sum of [i, j - 1] == k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int sum : sums) {
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }


        return ans;
    }
}
