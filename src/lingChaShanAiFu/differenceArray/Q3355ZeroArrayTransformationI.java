package lingChaShanAiFu.differenceArray;

public class Q3355ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            diff[l] += 1;
            diff[r + 1] -= 1;
        }

        int sumD = 0;
        for (int i = 0; i < nums.length; i++) {
            sumD += diff[i];
            // sumD stands for the summed decremented value
            if (nums[i] - sumD > 0) {
                return false;
            }
        }
        return true;
    }
}
