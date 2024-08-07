package karlCodeTraining.D35DP.ZeroOneBagKarlCode46;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve();

    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int weightNum = scanner.nextInt();
        int bagWeight = scanner.nextInt();

        int[] weights = new int[weightNum];
        int[] values = new int[weightNum];

        for (int i = 0; i < weightNum; i++) {
            weights[i] = scanner.nextInt();
        }

        for (int i = 0; i < weightNum; i++) {
            values[i] = scanner.nextInt();
        }

        int[][] arr = new int[weightNum][bagWeight + 1];

        for (int i = 1; i <= bagWeight; i++) {
            if (weights[0] <= i) {
                arr[0][i] = values[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j < bagWeight + 1; j++) {
                if (weights[i] > j) { // cannot put in
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(arr[weightNum - 1][bagWeight]);
    }
}
