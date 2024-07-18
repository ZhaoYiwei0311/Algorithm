package karlCodeTraining.D13BinaryTree.CountCompleteTreeNodes222;

public class Solution {

    /**
     * A recursive function that adopts divide and conquer thought
     * 1. A complete tree can be checked by left depth and right depth
     * 2. Can count by full tree
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 1;
        int rightDepth = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (rightDepth == leftDepth) {
            return (int) Math.pow(2, leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
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

