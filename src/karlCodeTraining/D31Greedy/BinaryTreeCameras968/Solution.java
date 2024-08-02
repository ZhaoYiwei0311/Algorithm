package karlCodeTraining.D31Greedy.BinaryTreeCameras968;

public class Solution {

    public int minCameraCover(TreeNode root) {
        if (traversal(root) == IS_NOTHING) {
            return count + 1;
        }
        return count;

    }

    int count = 0;

    final int IS_NOTHING = 0;
    final int IS_COVERED = 1;
    final int IS_CAMERA = 2;

    private int traversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            return IS_NOTHING;
        }
        int left = node.left == null ? IS_COVERED : traversal(node.left);
        int right = node.right == null ? IS_COVERED : traversal(node.right);
        if (left == IS_NOTHING || right == IS_NOTHING) {
            count++;
            return IS_CAMERA;
        }
        if (left == IS_CAMERA || right == IS_CAMERA) {
            return IS_COVERED;
        }
        return IS_NOTHING;
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

