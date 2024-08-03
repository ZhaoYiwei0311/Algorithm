package karlCodeTraining.D32DP.MinCostClimbingStairs746;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(s.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i < res.length; i++) {
            res[i] = Math.min(res[i - 2] + cost[i - 2], res[i - 1] + cost[i - 1]);
        }
        return res[cost.length];
    }
}
