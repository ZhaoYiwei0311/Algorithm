package karlCodeTraining.D15BinaryTree.ConstructBinaryTreeFromPreorderAndInorderTraversal105;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> inorderValueToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderValueToIndex.put(inorder[i], i);
        }
        return getNode(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode getNode(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd ) {
        if (inorderStart > inorderEnd || inorderStart >= inorder.length) {
            return null;
        }
        int middleValue = preorder[preorderStart];
        int middleIndexFromInorder = inorderValueToIndex.get(middleValue);
        int leftNodesLength = middleIndexFromInorder - inorderStart;
        int rightNodesLength = inorderEnd - middleIndexFromInorder;

        TreeNode middle = new TreeNode(middleValue);
        middle.left = getNode(preorder, inorder, middleIndexFromInorder - leftNodesLength, middleIndexFromInorder - 1, preorderStart + 1, preorderStart + leftNodesLength);
        middle.right = getNode(preorder, inorder, middleIndexFromInorder + 1, middleIndexFromInorder + rightNodesLength, preorderStart + leftNodesLength + 1, preorderStart + leftNodesLength + rightNodesLength);
        return middle;

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

