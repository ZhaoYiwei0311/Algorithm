package karlCodeTraining.D16BinaryTree.LowestCommonAncestorOfABinaryTree236;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Solution {
//    List<TreeNode> pathP = new ArrayList<>();
//    List<TreeNode> pathQ = new ArrayList<>();
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        traversal(new Stack<>(), pathP, p, root);
//        traversal(new Stack<>(), pathQ, q, root);
//        if (pathP.size() >= pathQ.size()) {
//            while (pathP.size() != pathQ.size()) {
//                pathP.removeLast();
//            }
//        } else {
//            while (pathQ.size() != pathP.size()) {
//                pathQ.removeLast();
//            }
//        }
//        while (!pathP.isEmpty()) {
//            if (pathP.getLast() == pathQ.getLast()) {
//                break;
//            } else {
//                pathP.removeLast();
//                pathQ.removeLast();
//            }
//        }
//        return pathP.removeLast();
//
//    }
//
//    private void traversal(List<TreeNode> path, List<TreeNode> targetPath, TreeNode targetNode, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        path.add(node);
//        if (node.val == targetNode.val) {
//            targetPath.addAll(path);
//            return;
//        }
//        traversal(path, targetPath, targetNode, node.left);
//        traversal(path, targetPath, targetNode, node.right);
//        path.removeLast();
//    }

    TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ((left == p && right == q) || (left == q && right == p)) {
            ancestor = root;
            return ancestor;
        }
        if ((root == p && (right == q || left == q))) {
            ancestor = root;
            return ancestor;
        }
        if ((root == q && (right == p || left == p))) {
            ancestor = root;
            return ancestor;
        }
        if (left == p || right == p) {
            return p;
        }
        if (left == q || right == q) {
            return q;
        }
        return Objects.requireNonNullElse(ancestor, root);
    }

    public TreeNode betterLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = betterLowestCommonAncestor(root.left, p, q);
        TreeNode right = betterLowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else { // 若找到两个节点
            return root;
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
