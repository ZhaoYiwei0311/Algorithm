package karlCodeTraining.D15BinaryTree.FindBottomLeftTreeValue513;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                if (i == 0) {
                    ans = pop.val;
                }
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
        }
        return ans;
    }

    public int findBottomLeftValueTraversal(TreeNode root) {
        traversal(root, 1);
        return targetNode.val;
    }

    int maxDepth = 0;
    TreeNode targetNode = null;

    private void traversal(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                targetNode = node;
                return;
            }
        }
        if (node.left != null) {
            traversal(node.left, depth + 1);
        }
        if (node.right != null) {
            traversal(node.right, depth + 1);
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

