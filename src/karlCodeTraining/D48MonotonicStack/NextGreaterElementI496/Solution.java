package karlCodeTraining.D48MonotonicStack.NextGreaterElementI496;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ints = solution.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int prevValue = nums2[stack.pop()];
                if (map.containsKey(prevValue)) {
                    res[map.get(prevValue)] = nums2[i];
                }
//                temp[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }

//        for (int i = 0; i < res.length; i++) {
//            res[i] = temp[map.get(i)];
//        }
        return res;

    }
}
