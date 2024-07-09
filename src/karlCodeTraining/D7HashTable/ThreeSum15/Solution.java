package karlCodeTraining.D7HashTable.ThreeSum15;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4};
        solution.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // duplicate check for a
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];

                int sum = curNum + leftNum + rightNum;
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(curNum, leftNum, rightNum));

                    // remove duplicate potential b and c after finding one
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }

        }
        return res;
    }
}
