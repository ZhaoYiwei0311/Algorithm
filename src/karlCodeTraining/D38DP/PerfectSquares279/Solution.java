package karlCodeTraining.D38DP.PerfectSquares279;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13;
        System.out.println(solution.numSquares(n));
    }

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i * i);
        }
        int[] squareArr = new int[squares.size()];
        for (int i = 0; i < squares.size(); i++) {
            squareArr[i] = squares.get(i);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 10001;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < squareArr.length; j++) {
                if (squareArr[j] <= i) {
                    dp[i] = Math.min(dp[i - squareArr[j]] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    public int betterNumSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //如果不想要寫for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
        //Arrays.fill(dp, Integer.MAX_VALUE);

        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                //if (dp[j - i * i] != max) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                //}
                //不需要這個if statement，因爲在完全平方數這一題不會有"湊不成"的狀況發生（ 一定可以用"1"來組成任何一個n），故comment掉這個if statement。
            }
        }
        return dp[n];
    }
}
