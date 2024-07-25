package karlCodeTraining.D23BackTrack.CombinationSum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = new int[] {2, 3, 5};
        int target = 2;
        List<List<Integer>> lists = s.combinationSum(candidates, target);
        for (List<Integer> aList : lists) {
            for (Integer i : aList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res =  new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,   0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i]);
            list.removeLast();
        }
    }
}
