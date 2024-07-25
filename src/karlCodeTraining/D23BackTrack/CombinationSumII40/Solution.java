package karlCodeTraining.D23BackTrack.CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int startIndex, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            used[i] = true;
            backtrack(candidates, i + 1, target - candidates[i]);
            used[i] = false;
            list.removeLast();
        }
    }
}
