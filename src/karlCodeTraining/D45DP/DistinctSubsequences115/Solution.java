package karlCodeTraining.D45DP.DistinctSubsequences115;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babgbag";
        String t = "bag";
        System.out.println(solution.numDistinct(s, t));
    }

    // dp means the number of t in s
    public int numDistinct(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int[][] dp = new int[charsS.length + 1][charsT.length + 1];
        for (int i = 1; i < charsT.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < charsS.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < charsS.length + 1; i++) {
            for (int j = 1; j < charsT.length + 1; j++) {
                if (charsS[i - 1] == charsT[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[charsS.length][charsT.length];
    }
}
