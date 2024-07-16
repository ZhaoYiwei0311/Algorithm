package karlCodeTraining.D11BinaryTree.PopulatingNextRightPointersInEachNode116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node before = q.poll();
                Node after = null;
                if (i != size - 1) {
                    after = q.peek();
                }
                before.next = after;
                if (before.left != null) {
                    q.add(before.left);
                }
                if (before.right != null) {
                    q.add(before.right);
                }

            }
        }
        return head;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

