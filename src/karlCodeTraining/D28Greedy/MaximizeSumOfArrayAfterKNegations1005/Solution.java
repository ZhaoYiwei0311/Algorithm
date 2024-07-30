package karlCodeTraining.D28Greedy.MaximizeSumOfArrayAfterKNegations1005;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-4, -2, -3};
        int k = 4;
        int i = s.largestSumAfterKNegations(nums, k);
        System.out.println(i);
    }

//    public int largestSumAfterKNegations(int[] nums, int k) {
//        Arrays.sort(nums);
//        int index = 0;
//        while (k != 0 && index < nums.length) {
//            if (nums[index] <= 0) {
//                nums[index] = -nums[index];
//                k--;
//            } else {
//                break;
//            }
//            index++;
//        }
//        if (k % 2 == 1) {
//            nums[index] = -nums[index];
//        }
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return sum;
//    }

    public int largestSumAfterKNegations(int[] nums, int K) {
        // sort by abs
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }
}
