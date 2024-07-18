package karlCodeTraining.D15BinaryTree.PathSum112;

public class Solution {
    boolean isFound = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        traversal(root, 0, targetSum);
        return isFound;
    }

    private void traversal(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                isFound = true;
                return;
            } else {
                return;
            }
        }
        if (node.left != null) {
            traversal(node.left,  node.val + sum, targetSum);
        }
        if (node.right != null) {
            traversal(node.right, node.val + sum, targetSum);
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



