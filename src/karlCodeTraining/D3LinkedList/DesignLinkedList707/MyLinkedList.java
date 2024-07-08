package karlCodeTraining.D3LinkedList.DesignLinkedList707;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList);

        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList);

        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3

        System.out.println(myLinkedList);
    }

    MyNode dummy = new MyNode();
    int length = 0;

    public MyLinkedList() {
        dummy.next = null;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        MyNode tempDummy = dummy;
        for (int i = 0; i < index; i++) {
            tempDummy = tempDummy.next;
        }
        return tempDummy.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(length, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) {
            return;
        }

        MyNode tempDummy = dummy;
        for (int i = 0; i < index; i++) {
            tempDummy = tempDummy.next;
        }
        MyNode newNode = new MyNode(val, tempDummy.next);
        tempDummy.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        }

        MyNode tempDummy = dummy;
        for (int i = 0; i < index; i++) {
            tempDummy = tempDummy.next;
        }
        tempDummy.next = tempDummy.next.next;
        length--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyNode tempDummy = dummy;
        for (int i = 0; i < length; i++) {
            tempDummy = tempDummy.next;
            sb.append(tempDummy.val).append("->");
        }
        return sb.toString();
    }
}

class MyNode {
    int val;
    MyNode next;

    public MyNode() {
    }

    public MyNode(int val) {
        this.val = val;
    }

    public MyNode(int val, MyNode next) {
        this.val = val;
        this.next = next;
    }
}
