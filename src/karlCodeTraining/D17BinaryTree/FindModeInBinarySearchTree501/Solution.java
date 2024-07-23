package karlCodeTraining.D16BinaryTree.FindModeInBina   rySearchTree501;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] ans = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            ans[index++] = integer;
        }
        return ans;
    }

    List<Integer> list = new ArrayList<>();
    TreeNode prev = null;
    int curNodeCount = -1;
    int curCount = 0;

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        if (prev == null) {
            curCount = 1;
        }
        if (prev != null && prev.val == node.val) {
            curCount++;
        } else if (prev != null) {
            curCount = 1;
        }

        if (curCount > curNodeCount) {
            curNodeCount = curCount;
            list = new ArrayList<>();
            list.add(node.val);
        } else if (curCount == curNodeCount) {
            list.add(node.val);
        }
        prev = node;

        traversal(node.right);
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

