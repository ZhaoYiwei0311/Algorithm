package hot100.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    static Solution s = new Solution();
    static int[] nums = new int[]{-2,0,0,2,2};

    public static void main(String[] args) {
        List<List<Integer>> lists = s.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int cur = i;
            int l = i + 1;
            int r = nums.length - 1;

            if (cur > 0 && nums[cur] == nums[cur - 1]) {
                continue;
            }

            while (l < r) {
                int sum = nums[cur] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[cur], nums[l], nums[r]));
                    boolean add = res.add(ans);
                    while (l < nums.length - 1) {
                        l++;
                        if (nums[l] == nums[l - 1]) {
                            continue;
                        }
                        break;
                    }

                    while (r > cur) {
                        r--;
                        if (nums[r] == nums[r + 1]) {
                            continue;
                        }
                        break;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }
        return res;

    }
}
