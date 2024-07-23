package karlCodeTraining.D16BinaryTree.SearchInABinarySearchTree700;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    TreeNode target = null;
//    public TreeNode searchBST(TreeNode root, int val) {
//        List<TreeNode> list = new ArrayList<>();
//        putList(list, root, val);
//        return target;
//    }

    private void putList(List<TreeNode> list, TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            target = node;
        }

        putList(list, node.left, val);
        list.add(node);
        putList(list, node.right, val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
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

