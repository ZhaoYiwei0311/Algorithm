package karlCodeTraining.D21BinaryTree.TrimABinarySeartchTree669;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        Solution s = new Solution();
        s.trimBST(root, 1, 2);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        return traversal(null, root, low, high);
    }


    private TreeNode traversal(TreeNode prevNode, TreeNode curNode, int low, int high) {
        if (curNode == null) {
            return null;
        }
        if (curNode.val < low) {
            return traversal(prevNode, curNode.right, low, high);
        } else if (curNode.val > high) {
            return traversal(prevNode, curNode.left, low, high);
        }
        curNode.left = traversal(curNode, curNode.left, low, high);
        curNode.right = traversal(curNode, curNode.right, low, high);
        return curNode;
    }

    public TreeNode betterTrimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
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

