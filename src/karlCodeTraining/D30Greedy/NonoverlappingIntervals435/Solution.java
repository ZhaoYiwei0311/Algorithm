package karlCodeTraining.D30Greedy.NonoverlappingIntervals435;

import javax.sound.sampled.SourceDataLine;
import java.util.Arrays;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{1,3}, {2,3}, {3,4}};
        Solution s = new Solution();
        System.out.println(s.betterEraseOverlapIntervals(nums));
    }
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int count = 0;
        int curMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < curMax) {
                count++;
                curMax = Math.min(curMax, intervals[i][1]);
            } else {
                curMax = intervals[i][1];
            }
        }
        return count;
    }

    // Sort by right border
    // Total intervals - non-overlapping intervals
    public int betterEraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int curMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= curMax) { // non-overlap
                curMax = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
