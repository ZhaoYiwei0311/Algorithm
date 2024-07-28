package karlCodeTraining.D24BackTrack.SubsetII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1, 2, 2};
        List<List<Integer>> lists = s.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
