package linkedlists;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        int length = length(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < length - k; i++) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            return head;
        }
        prev.next = null;
        ListNode ret = current;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        return ret;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        return len;
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
