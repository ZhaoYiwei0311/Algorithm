package karlCodeTraining.D7HashTable.FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[] {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        Solution s = new Solution();
        List<List<Integer>> lists = s.fourSum(nums, target);
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // truncate
            // -4 -3 -2 -1, target = 10
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) {
                    break;
                }

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
//                int targetSum = target - nums[i] - nums[j];

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
//                    long sum = (long)(nums[left] + nums[right] + nums[i] + nums[j]);
                    if ((long) nums[j] + nums[i] + nums[left] + nums[right] > target) {
                        right--;
                    } else if ((long) nums[j] + nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
