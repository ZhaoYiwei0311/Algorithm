package karlCodeTraining.D15BinaryTree.ConstructBinaryTreeFromInorderAndPostorderTraversal106;

import java.util.HashMap;

public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return getNode(inorder, postorder, 0, inorder.length - 1);

    }

    private TreeNode getNode(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int middleNodeIndexFromPostorder = -1;
        int middleNodeIndexFromInorder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            int value = inorder[i];
            int valueIndexFromPostorder = map.get(value);
            if (valueIndexFromPostorder > middleNodeIndexFromPostorder) {
                middleNodeIndexFromPostorder = valueIndexFromPostorder;
                middleNodeIndexFromInorder = i;
            }
        }
        TreeNode middleNode = new TreeNode(inorder[middleNodeIndexFromInorder]);
        middleNode.left = getNode(inorder, postorder, inorderStart, middleNodeIndexFromInorder - 1);
        middleNode.right = getNode(inorder, postorder, middleNodeIndexFromInorder + 1, inorderEnd);
        return middleNode;
    }

    private int findValueIndexFromPostorder(int[] postorder, int value) {
        for (int i = 0; i < postorder.length; i++) {
            if (value == postorder[i]) {
                return i;
            }
        }
        return -1;
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

