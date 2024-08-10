package karlCodeTraining.D37DP.ClimbStairsKarlCode57;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int stairs = scanner.nextInt();
        int step = scanner.nextInt();

        int[] dp = new int[stairs + 1];
        dp[0] = 1;
        for (int i = 1; i <= stairs; i++) {
            for (int j = 1; j <= step; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];

                }
            }
        }
        System.out.println(dp[stairs]);
    }
}
