package karlCodeTraining.D14BinaryTree.SumOfLeftLeaves404;

public class Solution {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        traversal(root);
        return sum;
    }

    private void traversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum += node.left.val;
                return;
            }
            traversal(node.left);
        }
        if (node.right != null) {
            traversal(node.right);

        }
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
