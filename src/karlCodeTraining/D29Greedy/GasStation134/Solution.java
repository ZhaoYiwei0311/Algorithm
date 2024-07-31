package karlCodeTraining.D29Greedy.GasStation134;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = new int[]{3,1,1};
        int[] cost = new int[]{1,2,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    // When curSum is negative, we cannot traverse to that point from all previous start
    // So we can only start from some point after that
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            int remain = 0;
//            int start = i;
//            while (true) {
//                remain -= cost[start];
//                remain += gas[start];
//                if (remain < 0) {
//                    break;
//                } else {
//                    start = (start + 1) % gas.length;
//
//                    if (start == i) {
//                        return i;
//                    }
//                }
//            }
//        }
//        return -1;
//    }
}
