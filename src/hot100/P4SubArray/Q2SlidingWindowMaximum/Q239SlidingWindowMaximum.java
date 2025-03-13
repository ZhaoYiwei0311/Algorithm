package hot100.P4SubArray.Q2SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Q239SlidingWindowMaximum {

    // Monoqueue and it stores index
    public int[] maxSlidingWindow(int[] nums, int k) {

        int [] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); //  two-sided queue

        for (int i = 0; i < nums.length; i++) {
            // Push
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast(); // ensure the monocity of queue
            }
            queue.addLast(i);

            // Remove
            if (i - queue.getFirst() >= k) {
                queue.removeFirst();
            }

            // Record
            if (i >= k - 1) {
                ans[i - k + 1] =  nums[queue.getFirst()];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Q239SlidingWindowMaximum so = new Q239SlidingWindowMaximum();
//        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] nums = new int[] {1,2};
        int k = 2;
        int[] ints = so.maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
