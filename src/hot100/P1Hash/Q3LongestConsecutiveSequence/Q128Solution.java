package hot100.P1Hash.Q3LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q128Solution {
    /**
     * The key is that if there is a smaller number existing, then it will always be better to start consecutive counts
     * from the smaller one.
     * Besides, remove duplicate by using set
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int ans = 1;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            } else {
                int start = i + 1;
                while (set.contains(start)) {
                    ans = Math.max(ans, start - i + 1);
                    start++;
                }
            }
        }
        return ans;

    }
}
