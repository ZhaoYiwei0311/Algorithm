package karlCodeTraining.D17BinaryTree.InsertIntoABinarySearchTree701;

public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        while (true) {
            if (val > temp.val && temp.right == null) {
                temp.right = new TreeNode(val);
                break;
            } else if (val > temp.val) {
                temp = temp.right;
            } else if (val < temp.val && temp.left == null) {
                temp.left = new TreeNode(val);
                break;
            } else {
                temp = temp.left;
            }
        }
        return root;
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

