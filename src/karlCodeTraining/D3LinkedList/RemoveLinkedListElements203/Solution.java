package karlCodeTraining.D3LinkedList.RemoveLinkedListElements203;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = head;

        while (right != null) {
            if (right.val == val) {
                right = right.next;
                left.next = right;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}