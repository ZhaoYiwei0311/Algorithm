package karlCodeTraining.D25BackTrack.NonDecreasingSubsequences491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{4, 6, 7, 7};

        List<List<Integer>> subsequences = s.findSubsequences(nums);
        for (List<Integer> subsequence : subsequences) {
            for (Integer i : subsequence) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


//    public List<List<Integer>> findSubsequences(int[] nums) {
//        backtrack(nums, 0);
//        return res;
//    }
//
//    private void backtrack(int[] nums, int startIndex) {
//        if (path.size() >= 2) {
//            res.add(new ArrayList<>(path));
//        }
//
//        // set for only this level
//        Set<Integer> set = new HashSet<>();
//        for (int i = startIndex; i < nums.length; i++) {
//            if (path.isEmpty() || (nums[i] >= path.getLast() && !set.contains(nums[i]))) {
//                set.add(nums[i]);
//
//                path.add(nums[i]);
//                backtrack(nums, i + 1);
//                path.removeLast();
//            }
//
//        }
//    }
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    private void backtrack(int[] nums, int startIndex){
        if(path.size() >= 2)
            res.add(new ArrayList<>(path));
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIndex; i < nums.length; i++){
            if(!path.isEmpty() && path.getLast() > nums[i] || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }






}
