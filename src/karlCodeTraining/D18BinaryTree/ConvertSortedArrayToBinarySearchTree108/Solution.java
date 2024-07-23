package karlCodeTraining.D18BinaryTree.ConvertSortedArrayToBinarySearchTree108;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode middleNode = new TreeNode(nums[mid]);
        middleNode.left = traversal(nums, left, mid - 1);
        middleNode.right = traversal(nums, mid + 1, right);
        return middleNode;
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
}



