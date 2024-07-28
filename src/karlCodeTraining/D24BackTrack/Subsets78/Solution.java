package karlCodeTraining.D24BackTrack.Subsets78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> subsets = s.subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer i : subset) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }


}
