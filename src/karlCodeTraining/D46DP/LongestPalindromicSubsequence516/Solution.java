package karlCodeTraining.D46DP.LongestPalindromicSubsequence516;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabaa";
        System.out.println(solution.longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
