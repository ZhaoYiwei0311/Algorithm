package lingChaShanAiFu.differenceArray;

public class Q2406DivideIntervalsIntoMiniMumNumberOfGroups {

    /**
     * Difference array is used here because overlapping array cannot be put into the same division
     * @param intervals
     * @return
     */
    public int minGroups(int[][] intervals) {
        int maxIndex = 0;
        for (int[] interval : intervals) {
            maxIndex = Math.max(interval[1], maxIndex);
        }
        int[] diff = new int[maxIndex + 2];
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            diff[l]++;
            diff[r + 1]--;
        }
        int ans = 0;
        int sum = 0;
        for (int i = 1; i <= maxIndex; i++) {
            sum += diff[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
