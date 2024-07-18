package karlCodeTraining.D14BinaryTree.BalancedBinaryTree110;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traversal(root) != Integer.MAX_VALUE;
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = traversal(node.left);
        int rightHeight = traversal(node.right);
        if ((Math.abs(leftHeight - rightHeight) > 1) || leftHeight == Integer.MAX_VALUE || rightHeight == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
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

