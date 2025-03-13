package hot100.P5Array.Q3RotateArray;

public class Q189RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);

    }

    private void reverse(int l, int r, int[] nums) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
