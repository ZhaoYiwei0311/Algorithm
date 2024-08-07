package karlCodeTraining.D36DP.OnesAndZeros474;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"10","0","1"};
        int zeros = 1;
        int ones = 1;
        System.out.println(solution.findMaxForm(strs, zeros, ones));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        int[] firstCount = getCounts(strs[0]);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (firstCount[0] <= i && firstCount[1] <= j) {
                    dp[0][i][j] = 1;
                }
            }
        }
        for (int i = 1; i < strs.length; i++) {
            int[] count = getCounts(strs[i]);
            int zeros = count[0];
            int ones = count[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (zeros > j || ones > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }

    private int[] getCounts(String string) {
        int[] count = new int[2];
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }
}
