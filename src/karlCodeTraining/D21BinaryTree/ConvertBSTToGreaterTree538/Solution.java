package karlCodeTraining.D21BinaryTree.ConvertBSTToGreaterTree538;

public class Solution {

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    TreeNode prevNode = null;
    int prevAccumulatedSum = 0;

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (prevNode == null) { // rightmost leaf, the biggest
                prevAccumulatedSum = node.val;
                return;
            } else {
                prevAccumulatedSum += node.val;
                node.val = prevAccumulatedSum;
                return;
            }
        }
        traversal(node.right);
        prevAccumulatedSum += node.val;
        node.val = prevAccumulatedSum;

        prevNode = node;
        traversal(node.left);
    }

    int sum = 0;
    public void betterTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        betterTraversal(node.right);
        sum += node.val;
        node.val = sum;
        betterTraversal(node.left);
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
}



