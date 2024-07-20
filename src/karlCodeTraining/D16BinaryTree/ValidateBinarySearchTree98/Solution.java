package karlCodeTraining.D16BinaryTree.ValidateBinarySearchTree98;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    public boolean isValidBST(TreeNode root) {
//        return compare(null, root, true) && compare(null, root, false);
//
//    }
//
//    private boolean compare(TreeNode prev, TreeNode cur, boolean leftCompare) {
//        if (cur == null) {
//            return true;
//        }
//        boolean left = false;
//        boolean right = false;
//        if (leftCompare) {
//            if (prev != null && prev.val <= cur.val) {
//                return false;
//            } else {
//                left = compare(cur, cur.left, true);
//                right = compare(cur, cur.right, false);
//                return left && right;
//            }
//        } else {
//            if (prev != null && prev.val >= cur.val) {
//                return false;
//            } else {
//                left = compare(cur, cur.left, true);
//                right = compare(cur, cur.right, false);
//                return left && right;
//            }
//        }
//    }

//    public boolean isValidBST(TreeNode root) {
//        List<TreeNode> list = new ArrayList<>();
//        putList(list, root);
//        boolean isBST = true;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).val <= list.get(i - 1).val) {
//                isBST = false;
//                break;
//            }
//        }
//        return isBST;
//    }
//
//    private void putList(List<TreeNode> list, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        putList(list, node.left);
//        list.add(node);
//        putList(list, node.right);
//    }

    TreeNode benchmark = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeft = isValidBST(root.left);
        if (!isLeft) {
            return false;
        }
        if (benchmark != null && benchmark.val >= root.val) {
            return false;
        }
        benchmark = root;
        boolean isRight = isValidBST(root.right);
        return isRight && isLeft;
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

