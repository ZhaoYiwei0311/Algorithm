package karlCodeTraining.D3LinkedList.ReverseLinkedList206;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;

        while (right != null && right.next != null) {
            ListNode next = right.next;
            right.next = left;
            next.next = right;
            left = right;
            right = next;
        }

        return right;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

