package karlCodeTraining.D45DP.DeleteOperationForTwoStrings582;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(solution.minDistance(word1, word2));
    }
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= chars2.length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (chars1[i - 1] != chars2[j - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }
}
