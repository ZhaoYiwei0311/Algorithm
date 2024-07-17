package karlCodeTraining.D13BinaryTree.BinaryTreePaths257;

import java.util.*;

public class Solution {

    List<Integer> path = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        traversal(root);
        return ans;
    }

    private void traversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            path.add(node.val);
            String onePath = pathToString();
            ans.add(onePath);
            path.removeLast();
            return;
        }
        path.add(node.val);
        if (node.left != null) {
            traversal(node.left);
        }
        if (node.right != null) {
            traversal(node.right);
        }
        path.removeLast();
    }

    private String pathToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
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

