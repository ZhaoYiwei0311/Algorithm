package karlCodeTraining.D46DP.PalindromicSubstrings647;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaa";
        System.out.println(solution.betterCountSubstrings(s));
    }

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (chars[i] == chars[j]) {
                    if (i >= j) {
                        continue;
                    }
                    if (Math.abs(i - j) <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public int betterCountSubstrings(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            res += extend(arr, i, i);
            res += extend(arr, i, i + 1);
        }


        return res;
    }

    private int extend(char[] arr, int leftStart, int rightStart) {
        int res = 0;
        while (leftStart >= 0 && rightStart < arr.length) {
            if (arr[leftStart] == arr[rightStart]) {
                leftStart--;
                rightStart++;
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
