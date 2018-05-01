package linkedlists;

public class IntersectionOfLinkedList {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int big = size(a);
        int small = size(b);
        ListNode bigNodeHead = a;
        ListNode smallNodeHead = b;
        int diff = big - small;
        if (big < small) {
            bigNodeHead = b;
            smallNodeHead = a;
            diff = small - big;
        }
        for (int i = 0; i < diff; i++) {
            bigNodeHead = bigNodeHead.next;
        }
        ListNode ret = null;
        while (bigNodeHead != null && bigNodeHead != smallNodeHead) {
            bigNodeHead = bigNodeHead.next;
            smallNodeHead = smallNodeHead.next;
        }
        ret = smallNodeHead;
        return ret;
    }

    private int size(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
