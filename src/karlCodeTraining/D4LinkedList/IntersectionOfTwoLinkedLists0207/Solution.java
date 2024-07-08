package karlCodeTraining.D4LinkedList.IntersectionOfTwoLinkedLists0207;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean firstTraversedA = false;
        boolean firstTraversedB = false;

        ListNode firstA = headA;
        ListNode firstB = headB;

        while (firstA != null && firstB != null) {
            if (firstA == firstB) {
                return firstA;
            }
            firstA = firstA.next;
            if (firstA == null && !firstTraversedA) {
                firstA = headB;
                firstTraversedA = true;
            }

            firstB = firstB.next;
            if (firstB == null && !firstTraversedB) {
                firstB = headA;
                firstTraversedB = true;
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

