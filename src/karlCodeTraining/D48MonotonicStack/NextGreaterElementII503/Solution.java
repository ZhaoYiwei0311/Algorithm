package karlCodeTraining.D48MonotonicStack.NextGreaterElementII503;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1};
        int[] ints = solution.nextGreaterElements(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        stack.push(0);
        for (int i = 1; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);

        }

        return res;

    }
}
