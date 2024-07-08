package karlCodeTraining.D4LinkedList.RemoveNthNodeFromEndOfList19;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }
        int step = length - n;
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = head;
        for (int i = 0; i < step; i++) {
            right = right.next;
            left = left.next;
        }
        ListNode next = right.next;
        left.next = next;
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

