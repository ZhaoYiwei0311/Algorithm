package karlCodeTraining.D38DP.WordBreak139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String string : wordDict) {
            set.add(string);
        }
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String subString = s.substring(j, i);
                if (set.contains(subString) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

}
