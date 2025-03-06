package hot100.P2TwoPointers.Q4TrappingRainWater;

public class Q42TrappingRainWater {

    /**
     * Use prefixMax and suffixMax
     * We populate the left highest board and right highest board
     * The shorter one minus the height would be the water volume contained in that block
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;

        int[] prefixHeights = new int[height.length];
        prefixHeights[0] = height[0];
        int[] suffixHeights = new int[height.length];
        suffixHeights[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            prefixHeights[i] = Math.max(prefixHeights[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            suffixHeights[i] = Math.max(suffixHeights[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            if (Math.min(prefixHeights[i], suffixHeights[i]) - height[i] > 0) {
                ans += Math.min(prefixHeights[i], suffixHeights[i]) - height[i];
            }
        }
        return ans;
    }

    /**
     * A better solution
     * When we know left highest is shorter than right highest, we know that block can only contain left highest - block height
     * The same applies to the case when right highest is shorter
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftHighest = 0;
        int rightHighest = 0;
        while (left <= right) {
            leftHighest = Math.max(height[left], leftHighest);
            rightHighest = Math.max(height[right], rightHighest);
            if (leftHighest < rightHighest) {
                ans += (leftHighest - height[left]);
                left++;
            } else {
                ans += (rightHighest - height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q42TrappingRainWater solution = new Q42TrappingRainWater();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution.trap2(height);
        System.out.println(trap);
    }
}
