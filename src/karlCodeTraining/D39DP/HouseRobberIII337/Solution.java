package karlCodeTraining.D39DP.HouseRobberIII337;

import javax.sound.midi.Soundbank;

public class Solution {
    public int rob(TreeNode root) {
        int[] traversal = traversal(root);
        return Math.max(traversal[0], traversal[1]);

    }

    private int[] traversal(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] left = traversal(node.left);
        int[] right = traversal(node.right);

        // do not steal current node
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // steal current node;
        res[1] = left[0] + right[0] + node.val;

        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

