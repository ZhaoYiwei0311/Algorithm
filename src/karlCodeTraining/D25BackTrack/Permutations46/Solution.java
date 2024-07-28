package karlCodeTraining.D25BackTrack.Permutations46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> permute = s.permute(nums);
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
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
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
