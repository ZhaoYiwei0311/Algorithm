package karlCodeTraining.D4LinkedList.SwapNodesInPairs24;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;

            if (next == null) {
                break;
            }
            ListNode nextNext = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = nextNext;

            pre = cur;
            cur = nextNext;
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

