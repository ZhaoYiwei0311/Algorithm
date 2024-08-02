package karlCodeTraining.D31Greedy.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{1,4}, {4, 5}};
        int[][] merge = s.merge(nums);
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int curMin = intervals[0][0];
        int curMax = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curMax) {
                curMax = Math.max(curMax, intervals[i][1]);
            } else {
                list.add(new int[]{curMin, curMax});
                curMin = intervals[i][0];
                curMax = intervals[i][1];
            }
        }
        list.add(new int[]{curMin, curMax});

        int[][] res =new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            res[i] = new int[]{ints[0], ints[1]};
        }
        return list.toArray(new int[list.size()][]);

    }
}
