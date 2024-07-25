package karlCodeTraining.D22BackTrack.Combinations77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> combine = s.combine(4, 2);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        betterBacktrack(1, n, k);
        return res;
    }

    private List<Integer> currentList = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private void backtrack(int start, int n, int k) {
        if (currentList.size() == k) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentList.add(i);
            backtrack(i + 1, n, k);
            currentList.removeLast();
        }
    }

    private void betterBacktrack(int start, int n, int k) {
        if (currentList.size() == k) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i <= n - (currentList.size()) + 1; i++) {
            currentList.add(i);
            backtrack(i + 1, n, k);
            currentList.removeLast();
        }
    }
}
