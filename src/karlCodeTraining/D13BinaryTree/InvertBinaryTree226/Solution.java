package karlCodeTraining.D13BinaryTree.InvertBinaryTree226;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        return traversal(root);
    }

    private TreeNode traversal(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = traversal(node.left);
        TreeNode rightNode = traversal(node.right);
        node.left = rightNode;
        node.right = leftNode;
        return node;
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

