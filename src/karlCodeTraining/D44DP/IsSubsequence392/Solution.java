package karlCodeTraining.D44DP.IsSubsequence392;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        String t = "";
        System.out.println(solution.isSubsequence(s, t));
    }
    public boolean isSubsequence(String s, String t) {
        char[] charsForS = s.toCharArray();
        char[] charsForT = t.toCharArray();
        if (s.isEmpty()) {
            return true;
        }

        int[][] dp = new int[charsForS.length + 1][charsForT.length + 1];
        for (int i = 1; i < charsForS.length + 1; i++) {
            for (int j = 1; j < charsForT.length + 1; j++) {
                if (charsForS[i - 1] == charsForT[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[charsForS.length][charsForT.length] == charsForS.length;
    }
}
