package karlCodeTraining.D34DP.IntegerBreak343;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(6));
    }
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            int start = 1;
            int max = 1;
            while (start <= i / 2 + 1) {
                // start * arr[i - start] means further division of i - start
                // start * (i - start) means no further division of i - start
                max = Math.max(Math.max(start * (arr[i - start]), max), start * (i - start));
                start++;
            }
            arr[i] = max;
        }
        return arr[arr.length - 1];
    }
}
