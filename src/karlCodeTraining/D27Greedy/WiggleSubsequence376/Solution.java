package karlCodeTraining.D27Greedy.WiggleSubsequence376;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        // the ascending summit

        // 1.head and tail
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        int preDiff = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int curDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                // 2. flat wiggle
                count++;

                // 3. flat mono
                preDiff = curDiff;
            }
        }
        return count;

    }
}
