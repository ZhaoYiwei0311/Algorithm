package karlCodeTraining.D4LinkedList.LinkedListcycleII142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast == null) {
                return null;
            }
            fast = fast.next;

            if (slow == fast) {
                slow = dummy;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}


class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

