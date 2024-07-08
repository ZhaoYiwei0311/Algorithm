package competition.leetcode.week396.minimumNumberOfOperationsToMakeWorkKPeriodic;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeWorkKPeriodic {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "hnccccajbwccajut";
        int k = 2;
        System.out.println(s.minimumOperationsToMakeKPeriodic(ss, k));
    }
}

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 0; i + k <= word.length(); i+= k) {
            String s = word.substring(i, i + k);
            int cur = count.getOrDefault(s, 0) + 1;
            max = Math.max(cur, max);
            count.put(s, cur);
        }
        int len = word.length();
        int times = len / k;
        return times - max;

    }
}
