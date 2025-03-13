package competition.leetcode.week424;

public class Q3356ZeroArrayTransformationII {
    /**
     * k has monotocity feature, so we can use binary search to find the minimum k
     * @param nums
     * @param queries
     * @return
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        int qLength = queries.length;
        int left = -1;
        int right = qLength + 1;
        while (left + 1< right) {
            int mid = (right + left) / 2;
            if (check(mid, nums, queries)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right <= qLength ? right : -1;
    }

    /**
     * Difference array is the key concept in this question
     * @param mid
     * @param nums
     * @param queries
     * @return
     */
    private boolean check(int mid, int[] nums, int[][] queries) {
        int numsLength = nums.length;
        int[] diff = new int[numsLength + 1];
        for (int i = 0; i < mid; i++) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            int val = q[2];
            diff[l] += val;
            diff[r + 1] -= val;
        }
        int sumD = 0;
        for (int i = 0; i < numsLength; i++) {
            sumD += diff[i];
            if (nums[i] > sumD) {
                return false;
            }
        }
        return true;
    }


}
