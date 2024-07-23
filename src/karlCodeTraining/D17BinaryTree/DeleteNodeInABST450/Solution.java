package karlCodeTraining.D17BinaryTree.DeleteNodeInABST450;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // case when both two sides are not empty
            // rightNode's first empty left node will become leftNode
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            TreeNode tempRightNode = rightNode;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            rightNode.left = leftNode;
            return tempRightNode;
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

