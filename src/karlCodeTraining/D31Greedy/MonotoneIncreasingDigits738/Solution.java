package karlCodeTraining.D31Greedy.MonotoneIncreasingDigits738;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 332;
        System.out.println(s.monotoneIncreasingDigits(num));
    }

    // Traverse from right to left, so that we can utilize previous result
    public int monotoneIncreasingDigits(int n) {
        char[] arr = (n + "").toCharArray();
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    arr[j] = '9';
                }
                arr[i] = (char) (arr[i] - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return Integer.valueOf(sb.toString());

    }

    public int betterMonotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        // start to record where to change to 9
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
