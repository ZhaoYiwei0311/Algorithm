package karlCodeTraining.D12StackAndQueue.SlidingWindowMaximum239;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1,-1};
        int k = 1;
        int[] ints = s.betterMaxSlidingWindow(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * keep track of a descending dequeue
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> monoQueue = new LinkedList<>();
        Queue<Integer> containerQueue = new LinkedList<>();

        int[] ans = new int[nums.length + 1 - k];
        int index = 0;

        for (int i = 0; i < k; i++) {
            containerQueue.add(nums[i]);
            while (!monoQueue.isEmpty()) {
                int curMin = monoQueue.getLast();
                if (curMin < nums[i]) {
                    monoQueue.removeLast();
                } else {
                    break;
                }
            }
            monoQueue.addLast(nums[i]);

        }
        ans[index++] = monoQueue.getFirst();

        for (int i = k; i < nums.length; i++) {
            int polledFromContainer = containerQueue.poll();
            int curMax = monoQueue.peek();
            if (polledFromContainer == curMax) {
                monoQueue.poll();
            }
            containerQueue.add(nums[i]);
            while (!monoQueue.isEmpty()) {
                int curMin = monoQueue.getLast();
                if (curMin < nums[i]) {
                    monoQueue.removeLast();
                } else {
                    break;
                }
            }
            monoQueue.addLast(nums[i]);
            ans[index++] = monoQueue.getFirst();
        }

        return ans;
    }

    public int[] betterMaxSlidingWindow(int[] nums, int k) {
        MyQueue monoQueue = new MyQueue();

        int[] ans = new int[nums.length + 1 - k];
        int index = 0;

        for (int i = 0; i < k; i++) {
            monoQueue.add(nums[i]);
        }
        ans[index++] = monoQueue.peek();
        for (int i = k; i < nums.length; i++) {
            monoQueue.poll(nums[i - k]);
            monoQueue.add(nums[i]);
            ans[index++] = monoQueue.peek();

        }

        return ans;
    }

    class MyQueue {
        Deque<Integer> monoDeque = new LinkedList<>();

        void add(Integer val) {
            while (!monoDeque.isEmpty() && monoDeque.getLast() < val) {
                monoDeque.removeLast();
            }
            monoDeque.addLast(val);
        }

        void poll(int val) {
            if (!monoDeque.isEmpty() && monoDeque.getFirst() == val) {
                monoDeque.removeFirst();
            }
        }

        int peek() {
            return monoDeque.getFirst();
        }
    }
}
