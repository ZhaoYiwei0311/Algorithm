package hot100.P2TwoPointers.Q1MoveZeros;

public class Q283Solution {

    /**
     * Two pointers
     * [0, left pointer] shall all be none-zero
     * (left pointer, right pointer] shall be zeros
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        Q283Solution solution = new Q283Solution();
        int[] nums = new int[]{4,2,4,0,0,3,0,5,1,0};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
