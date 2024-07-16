package karlCodeTraining.D11BinaryTree.NaryTreeLevelOrderTraversal429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                list.add(poll.val);
                for (Node child : poll.children) {
                    if (child != null) {
                        q.add(child);
                    }
                }
            }

            ans.add(list);
        }
        return ans;

    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

