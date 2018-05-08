package linkedlists;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = size(head);
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < size / 2; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        ListNode first = head;
        ListNode second = current;
        ListNode sortedFirst = sortList(first);
        ListNode sortedSecond = sortList(second);
        ListNode merged = merge(sortedFirst, sortedSecond);
        return merged;
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode ret = new ListNode(-1);
        ListNode f = first;
        ListNode s = second;
        ListNode cur = ret;
        while (f != null && s != null) {
            if (f.val < s.val) {
                cur.next = f;
                f = f.next;
                cur = cur.next;
            } else {
                cur.next = s;
                s = s.next;
                cur = cur.next;
            }
        }
        if (f == null) {
            cur.next = s;
        }
        if (s == null) {
            cur.next = f;
        }
        return ret.next;
    }

    private int size(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
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
