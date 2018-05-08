package linkedlists;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(-1);
        ListNode sorted = ret;
        ListNode current = head;
        while (current != null) {
            ListNode nxt = current.next;
            current.next = null;
            insert(sorted, current);
            current = nxt;
        }
        return ret.next;
    }

    private void insert(ListNode sorted, ListNode current) {
        ListNode head = sorted.next;
        if (head == null) {
            sorted.next = current;
            return;
        }
        ListNode prev = sorted;
        while (head != null && head.val < current.val) {
            prev = head;
            head = head.next;
        }
        prev.next = current;
        current.next = head;
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
