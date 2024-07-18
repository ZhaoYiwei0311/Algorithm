package karlCodeTraining.D11BinaryTree.MaximumDepthOfBinaryTree104;

public class Solution {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        return traversal(root, depth);


    }

    private int traversal(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        int leftDepth = traversal(node.left, depth);
        int rightDepth = traversal(node.right, depth);
        return Math.max(leftDepth, rightDepth);
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

