package karlCodeTraining.D15BinaryTree.PathSumII113;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        traversal(root, 0, targetSum);
        return ans;
    }

    private void traversal(TreeNode node, int sum, int targetSum) {
        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                path.add(node.val);
                List<Integer> newList = new ArrayList<>(path);
                ans.add(newList);
                path.removeLast();
            }
            return;
        }
        path.add(node.val);
        if (node.left != null) {
            traversal(node.left, sum + node.val, targetSum);
        }
        if (node.right != null) {
            traversal(node.right, sum + node.val, targetSum);
        }
        path.removeLast();
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

