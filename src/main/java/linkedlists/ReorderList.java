package linkedlists;

public class ReorderList {

    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode rev = reverse(slow);
        ListNode current = head;
        ListNode ret = current;
        while (current != null) {
            ListNode n1 = current.next;
            ListNode n2 = rev.next;
            current.next = rev;
            rev.next = n1;
            prev = rev;
            rev = n2;
            current = n1;
        }
        if (rev != null) {
            prev.next = rev;
        }

        return ret;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
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
