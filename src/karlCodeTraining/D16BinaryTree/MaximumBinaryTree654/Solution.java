package karlCodeTraining.D16BinaryTree.MaximumBinaryTree654;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length - 1);

    }

    private TreeNode traversal(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = traversal(nums, start, maxIndex - 1);
        node.right = traversal(nums, maxIndex + 1, end);
        return node;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

