package karlCodeTraining.D30Greedy.MinimumNumberOfArrowsToBurstBalloons452;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(s.findMinArrowShots(nums));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        int curMax = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > curMax) {
                count++;
                curMax = points[i][1];
            }
            if (points[i][1] <= curMax) {
                curMax = points[i][1];
            }
        }
        return count;

    }
}
