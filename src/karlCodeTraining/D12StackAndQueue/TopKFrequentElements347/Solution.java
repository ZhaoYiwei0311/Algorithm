package karlCodeTraining.D12StackAndQueue.TopKFrequentElements347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            ans[i] = poll[0];
        }

        return ans;
    }

}
