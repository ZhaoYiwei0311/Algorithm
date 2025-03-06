package hot100.P2TwoPointers.Q3ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int cur = nums[i];
            if (cur + nums[i + 1] + nums[i + 2] > 0) {
                // The sum of the smallest numbers are already bigger, no meaning to continue
                break;
            }
            if (cur + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                // The sum of the biggest numbers are already smaller, continue
                continue;
            }
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (cur + nums[left] + nums[right] > 0) {
                    right--;
                } else if (cur + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q15ThreeSum solution = new Q15ThreeSum();
        int[] nums = new int[]{0,0,0};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
