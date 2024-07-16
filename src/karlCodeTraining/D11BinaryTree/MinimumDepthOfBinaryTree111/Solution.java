package karlCodeTraining.D11BinaryTree.MinimumDepthOfBinaryTree111;

public class Solution {

    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        return traversal(root, 0);
    }

    private int traversal(TreeNode node, int depth) {

        depth++;
        if (node.left == null && node.right == null) {
            return depth;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (node.left != null) {
            leftDepth = traversal(node.left, depth);
        }
        if (node.right != null) {
            rightDepth = traversal(node.right, depth);
        }
        return Math.min(leftDepth, rightDepth);
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

