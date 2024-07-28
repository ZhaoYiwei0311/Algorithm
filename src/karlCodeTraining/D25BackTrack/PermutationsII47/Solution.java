package karlCodeTraining.D25BackTrack.PermutationsII47;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = s.permuteUnique(nums);
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // used in same level
                continue;
            }
            if (!used[i]) {
                // not used in same branch
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
