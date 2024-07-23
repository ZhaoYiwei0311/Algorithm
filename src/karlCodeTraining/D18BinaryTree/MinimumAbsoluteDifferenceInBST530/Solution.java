package karlCodeTraining.D18BinaryTree.MinimumAbsoluteDifferenceInBST530;

public class Solution {

    TreeNode prevNode = null;
    public int getMinimumDifference(TreeNode root) {
        return traversal(root);
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int leftDiff = traversal(node.left);
        int curDiff = prevNode == null ? Integer.MAX_VALUE : Math.abs(prevNode.val - node.val);
        prevNode = node;
        int rightDiff = traversal(node.right);
        return Math.min(Math.min(leftDiff, curDiff), rightDiff);
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

