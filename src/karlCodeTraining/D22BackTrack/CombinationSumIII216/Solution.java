package karlCodeTraining.D22BackTrack.CombinationSumIII216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 9;
        List<List<Integer>> lists = solution.combinationSum3(k, n);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private List<Integer> currentList = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n);
        return res;
    }

    private void backtrack(int start, int k, int target) {
        if (currentList.size() == k && target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        } else if (currentList.size() == k) {
            return;
        }
        if (start > target) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            currentList.add(i);
            int newTarget = target - i;
            backtrack(i + 1, k, newTarget);
            currentList.removeLast();
        }
    }
}
