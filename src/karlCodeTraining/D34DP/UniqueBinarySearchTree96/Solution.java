package karlCodeTraining.D34DP.UniqueBinarySearchTree96;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.numTrees(n));
    }
    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            int count = 0;
            for (int j = 1; j <= i ; j++) {
                count += arr[j - 1] * arr[i - j];
            }
            arr[i] = count;
        }
        return arr[n];
    }
}
