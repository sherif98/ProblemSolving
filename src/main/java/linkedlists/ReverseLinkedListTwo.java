package linkedlists;

public class ReverseLinkedListTwo {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; i < m - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode startHead = prev;
        ListNode endHead = current;
        prev = null;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        if (startHead != null) {
            startHead.next = prev;
        }
        endHead.next = current;
        if (startHead != null) {
            return head;
        }
        return prev;
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
