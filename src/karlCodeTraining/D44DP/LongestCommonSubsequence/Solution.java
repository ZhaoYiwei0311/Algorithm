package karlCodeTraining.D44DP.LongestCommonSubsequence;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution =  new Solution();
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";

        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] charsText1 = text1.toCharArray();
        char[] charsText2 = text2.toCharArray();

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (charsText1[i - 1] == charsText2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[charsText1.length][charsText2.length];

    }
}
